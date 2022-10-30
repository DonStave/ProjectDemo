package com.my.util;


import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Author: Don
 * Date: 2019/12/23
 * BaseDao工具类
 */
public class BaseDao<T> {
    //获取链接对象
    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String password = null;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    static {
        try {
            //1. 创建一个属性配置对象
            Properties properties = new Properties();
            InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //使用类加载器，去读取src底下的资源文件
            //导入输入流
            properties.load(inputStream);

            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 实现连接方法 获取数据库连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公共的增删改方法
     *
     * @param sql
     * @param objects
     * @return
     */
    public int excuteUpdate(String sql, Object[] objects) {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return 0;
    }

    /**
     * 公共的查询方法
     *
     * @param sql
     * @param objects
     * @return
     */
    public List<Map<String, Object>> excuteQuery(String sql, Object[] objects) {
        try {
            List<Map<String, Object>> mapList = new ArrayList<>();
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    map.put(resultSetMetaData.getColumnName(i), rs.getString(i));
                }
                mapList.add(map);
            }
            return mapList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return null;
    }

    /**
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public List<T> queryList(String sql, Object[] params, Class<?> clazz) {
        List<T> list = new ArrayList<T>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int colCount = md.getColumnCount();
            String fieldName = "";
            Field field = null;
            while (rs.next()) {
                T obj = (T) clazz.newInstance();
                for (int i = 1; i <= colCount; i++) {
                    fieldName = md.getColumnName(i);
                    try {
                        field = clazz.getDeclaredField(fieldName);
                        field.setAccessible(true);
                        field.set(obj, convert(rs.getString(i), field.getType()));
                    } catch (Exception e) {

                    }
                }
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return null;
    }

    /*public List<T> queryList(String sql, List<Object> params, Class<?> clazz) {
        List<T> list = new ArrayList<T>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int colCount = md.getColumnCount();
            String fieldName = "";
            Field field = null;
            while (rs.next()) {
                //动态创建新对象
                T obj = (T) clazz.newInstance();
                for (int i = 1; i <= colCount; i++) {
                    fieldName = md.getColumnName(i);
                    try {
                        field = clazz.getDeclaredField(fieldName);
                        field.setAccessible(true);
                        field.set(obj, convert(rs.getString(i), field.getType()));
                    } catch (Exception e) {

                    }
                }
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return null;
    }*/

    private <T extends Serializable> T convert(String param, Class<?> clas) {
        if (param == null || param == "" || clas == null) {
            return null;
        }
        String type = clas.getName();
        if (type.equals("java.lang.String")) {
            return (T) param;
        }
        try {
            if (type.equals("java.util.Date")) {
                return (T) new java.util.Date(Timestamp.valueOf(param).getTime());
            }
            if (type.equals("java.sql.Date")) {
                return (T) new java.sql.Date(Timestamp.valueOf(param).getTime());
            }
            if (type.equals("java.sql.Timestamp")) {
                return (T) Timestamp.valueOf(param);
            }
            if (type.equals("java.lang.Char")) {
                return (T) Character.valueOf(param.charAt(0));
            }
            if (type.equals("java.lang.Integer") || type.equals("int")) {
                return (T) Integer.valueOf(param);
            }
            if (type.equals("java.lang.Double") || type.equals("double")) {
                return (T) Double.valueOf(param);
            }
            if (type.equals("java.lang.Float") || type.equals("float")) {
                return (T) Float.valueOf(param);
            }
            if (type.equals("java.lang.Byte") || type.equals("byte")) {
                return (T) Byte.valueOf(param);
            }
            if (type.equals("java.lang.Short") || type.equals("short")) {
                return (T) Short.valueOf(param);
            }
            if (type.equals("java.lang.Long") || type.equals("long")) {
                return (T) Long.valueOf(param);
            }
            if (type.equals("java.lang.Boolean") || type.equals("boolean")) {
                return (T) Boolean.valueOf(param);
            }
        } catch (Exception e) {

        }
        return null;
    }
    
    /**
     * 释放资源方法
     *
     * @param conn
     * @param ps
     * @param rs
     */
    private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
