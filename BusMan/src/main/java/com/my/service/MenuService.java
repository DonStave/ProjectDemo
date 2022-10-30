package com.my.service;

import com.my.entity.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 菜单管理业务层
 */
public interface MenuService {

    /**
     * 拼装树形数据
     *
     * @return
     */
    List<TreeNode> getTreeData();

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
     * @param menuId
     * @return
     */
    int delete(int menuId);

    /**
     * 根据登录用户id查询该用户对象的所有权限菜单#{userId}
     *
     * @param userId
     * @return
     */
    List<TreeNode> listMenuByUserId(int userId);
}
