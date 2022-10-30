package com.my.mapper;

import com.my.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 用户管理
 */
public interface UserDao {


    /**
     * 根据用户名查询用户信息（登录使用）
     *
     * @param userName
     * @return
     */
    @Select("select user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time from sys_user where  del_flag=0 and user_name=#{userName}")
    Map getUserByUserName(String userName);

    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    @Select("<script>select user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time from sys_user " +
            " where del_flag=0 " +
            "<if test=\"loginName!=null and loginName!=''\"> and login_name like concat('%',#{loginName},'%') </if>" +
            "<if test=\"userName!=null and userName!=''\"> and user_name=#{userName} </if>" +
            "<if test=\"passWord!=null and passWord!=''\"> and password=#{passWord} </if>" +
            "<if test=\"email!=null and email!=''\"> and email like concat('%',#{email},'%') </if>" +
            "<if test=\"phoneNumber!=null and phoneNumber!=''\"> and phonenumber like concat('%',#{phoneNumber},'%')  </if>" +
            "<if test=\"status!=null and status!=''\">  and status=#{status} </if>" +
            "</script>")
    List<Map> list(Map map);

    /***
     * 添加
     * @param map
     * @return
     */
    @Insert("insert into sys_user (login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time) VALUES " +
            "(#{login_name},#{user_name},#{user_type},#{email},#{phonenumber},#{sex},#{avatar},#{password},#{salt}" +
            ",0,0,null,null,#{userName},now(),#{userName},now())")
    int add(Map map);

    /**
     * 更新
     *
     * @param map
     * @return
     */
    @Update("update sys_user set login_name=#{login_name}, user_name=#{user_name}, user_type=#{user_type}," +
            " email=#{email}, phonenumber=#{phonenumber}, sex=#{sex}, avatar=#{avatar},password=#{password}, " +
            "salt=#{salt}, status=#{status},update_by=#{userName}, update_time=now() " +
            " where user_id=#{user_id}")
    int update(Map map);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @Update("update sys_user set del_flag=2 where user_id=#{userId}")
    int delete(int userId);

    /**
     * 查询用户id对应的角色id集合
     *
     * @param userId
     * @return
     */
    @Select("select role_id from sys_user_role where user_id=#{userId}")
    List<Integer> listRoleIdsByUserId(int userId);

    /**
     * 删除原有用户ID关联的所有角色
     *
     * @param userId
     * @return
     */
    @Delete("delete from sys_user_role where user_id=#{userId}")
    int delteRoleIdsByUserId(int userId);

    /**
     * 添加用户角色关联
     *
     * @param values
     * @return
     */
    @Insert("insert into sys_user_role values ${values}")
    int addUserAndRole(String values);

    /**
     * 登录成功后，更新登录时间和登录IP
     *
     * @param map
     * @return
     */
    @Update("update sys_user set login_ip=#{loginIp},login_date=now() where user_name=#{userName}")
    int updateLoginInfoByUserName(Map map);

    @Select("select * from sys_user where role_id != 1")
    List<User> getAll();
}
