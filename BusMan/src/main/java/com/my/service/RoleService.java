package com.my.service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 角色管理业务层
 */
public interface RoleService {
    /**
     * 列表
     *
     * @return
     */
    Map list(Map map);

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
     * @param roleId
     * @return
     */
    int delete(int roleId);


    /**
     * 根据角色查询该角色拥有的所有权限id
     *
     * @param roleId
     * @return
     */
    List<Integer> listMenuByRoleId(int roleId);


    /**
     * 添加角色权限关联数据
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    int addRoleAndMenu(int roleId, String menuIds);
}
