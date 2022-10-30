package com.my.service;


import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 用户管理业务层
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息（登录使用）
     *
     * @param userName
     * @return
     */
    Map getUserByUserName(String userName);

    /**
     * 根据条件查询
     *
     * @param map
     * @return
     */
    Map getList(Map map);

    /***
     * 添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 更新
     *
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    int delete(int userId);

    /**
     * 查询用户id对应的角色id集合
     *
     * @param userId
     * @return
     */
    List<Integer> listRoleIdsByUserId(int userId);

    /**
     * 删除原有用户ID关联的所有角色
     *
     * @param userId
     * @return
     */
    int delteRoleIdsByUserId(int userId);

    /**
     * 添加用户角色关联
     *
     * @param userId
     * @param roleIds
     * @return
     */
    int addUserAndRole(int userId, String roleIds);

    /**
     * 登录成功后，更新登录时间和登录IP
     *
     * @param map
     * @return
     */
    int updateLoginInfoByUserName(Map map);
}
