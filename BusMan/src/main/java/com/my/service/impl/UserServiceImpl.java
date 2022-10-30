package com.my.service.impl;

import com.my.mapper.UserDao;
import com.my.util.SessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.service.UserService;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author: Don
 * 用户管理业务层实现类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;


    @Override
    public Map getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public Map getList(Map map) {
        int pageNo = Integer.valueOf(map.get("pageNo") + "");
        int pageSize = Integer.valueOf(map.get("pageSize") + "");
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Map> pageInfo = new PageInfo<Map>(userDao.list(map));
        Map rmap = new HashMap();
        rmap.put("total", pageInfo.getTotal());
        rmap.put("page", pageInfo.getList());
        return rmap;
    }

    @Override
    public int add(Map map) {
        map.put("userName", SessionUtil.getUserName());
        //盐值
        String salt = UUID.randomUUID().toString().substring(0, 15);
        //随机盐值，放入数据库
        map.put("salt", salt);
        //获取用户输入的原始密码
        Object passWord = map.get("password");
        //使用SHA512加密算法，把原始密码和随机到的盐值一起进行运算，得到密码，存入数据
        //Sha512Hash(Object source, Object salt, int hashIterations)
        // 第1个参数，原始密码，第2参数，随机盐值  第3参数 hash次数
        //  和配置类中配置的加密算法名称和hash次数一致 com.my.config.ShiroConfig
        Sha512Hash sha512Hash = new Sha512Hash(passWord, salt, 1024);
        //设置参数
        map.put("password", sha512Hash.toString());
        return userDao.add(map);
    }

    @Override
    public int update(Map map) {

        map.put("userName", SessionUtil.getUserName());
        return userDao.update(map);
    }

    @Override
    public int delete(int userId) {
        //删除用户(假删除)
        userDao.delete(userId);
        //删除该用户级联的所有角色ID
        return userDao.delteRoleIdsByUserId(userId);
    }

    @Override
    public List<Integer> listRoleIdsByUserId(int userId) {
        return userDao.listRoleIdsByUserId(userId);
    }

    @Override
    public int delteRoleIdsByUserId(int userId) {
        return userDao.delteRoleIdsByUserId(userId);
    }

    @Override
    public int addUserAndRole(int userId, String roleIds) {
        try {
            //调用上面方法，删除该用户关联的所有角色
            this.delteRoleIdsByUserId(userId);
            StringBuffer stringBuffer = new StringBuffer();
            //分割字符串，循环拼接values后面  (1,1),(1,2),(1,10)...
            String[] ridArray = roleIds.split(",");
            for (String rid : ridArray) {
                stringBuffer.append("(" + userId + "," + rid + "),");
            }
            String values = stringBuffer.substring(0, stringBuffer.length() - 1);
            userDao.addUserAndRole(values);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateLoginInfoByUserName(Map map) {
        return userDao.updateLoginInfoByUserName(map);
    }

    //    测试
    public static void main(String[] args) {
        //盐值
        String salt = UUID.randomUUID().toString().substring(0, 15);
        //随机盐值，放入数据库

        //获取用户输入的原始密码

        //使用SHA512加密算法，把原始密码和随机到的盐值一起进行运算，得到密码，存入数据
        //Sha512Hash(Object source, Object salt, int hashIterations)
        //          第1个参数，原始密码，第2参数，随机盐值  第3参数 hash次数
        //           和配置类中配置的加密算法名称和hash次数一致 com.my.config.ShiroConfig
        Sha512Hash sha512Hash = new Sha512Hash("admin", "1eacb797-736e-4", 1024);
        //设置参数
        System.out.println("盐值为：" + salt + ",计算后的密码：" + sha512Hash.toString());
        //    System.out.println("39f6d18d34ec7eea6cb91ceb6c078541ec81dd7ffe5d0b0cd2652063158df6c9d3a99ec0db8451b743c55b09f73b2c3e54201e570890870d5a3440642b8f5f08".length());
    }
}
