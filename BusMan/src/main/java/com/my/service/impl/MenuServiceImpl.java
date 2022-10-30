package com.my.service.impl;

import com.my.mapper.MenuDao;
import com.my.entity.TreeNode;
import com.my.util.SessionUtil;
import com.my.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 菜单业务层实现类
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private HttpSession session;

    @Override
    public List<TreeNode> getTreeData() {
        //获取所有的菜单列表
        List<TreeNode> menuList = menuDao.getList();
        List<TreeNode> tempTreeList = new ArrayList<TreeNode>();
        //判断是否为空
        if (menuList != null && menuList.size() > 0) {
            //循环
            for (TreeNode treeNode : menuList) {
                //判断是否是一级菜单
                if (treeNode.getParentId() == 0) {
                    treeNode.setParentName("根节点");
                    //添加一级菜单
                    tempTreeList.add(treeNode);
                    //为菜单找子节点
                    bindChildren(treeNode, menuList);
                }
            }
        }
        return tempTreeList;
    }

    /**
     * 绑定子节点(从所有菜单中查询当前节点的子节点)
     *
     * @param crrentNode  当前节点
     * @param allMenuList 所有节点
     */
    private void bindChildren(TreeNode crrentNode, List<TreeNode> allMenuList) {
        //因为上面调用前已经判断集合不空，不用判断，直接循环
        for (TreeNode treeNode : allMenuList) {
            //判断当前循环的节点的父节点是否和当前节点ID相等，如果相等，说明当前循环节点是子节点
            if (treeNode.getParentId() == crrentNode.getId()) {
                //获取当前节点的所有孩子,如果原来没有子节点，子节点集合为空
                List<TreeNode> childrens = crrentNode.getChildren();
                //为空，实例化
                if (childrens == null) {
                    childrens = new ArrayList<TreeNode>();
                }
                //递归时，如果某节点是当前节点的子节点，设置它的节点名称为当前节点名称
                treeNode.setParentName(crrentNode.getLabel());
                //添加当前循环节点到子节点集合中
                childrens.add(treeNode);
                //为当前节点设置子节点集合
                crrentNode.setChildren(childrens);
                //自己调用自己(递归recursive)，为当前循环节点找子节点
                bindChildren(treeNode, allMenuList);
            }
        }
    }

    @Override
    public int add(Map map) {
        map.put("userName", SessionUtil.getUserName());
        return menuDao.add(map);
    }

    @Override
    public int update(Map map) {
        map.put("userName", SessionUtil.getUserName());
        return menuDao.update(map);
    }

    @Override
    public int delete(int menuId) {
        return menuDao.delete(menuId);
    }

    @Override
    public List<TreeNode> listMenuByUserId(int userId) {
        List<TreeNode> menuList = menuDao.listMenuByUserId(userId);
        List<TreeNode> tempTreeList = new ArrayList<TreeNode>();
        //判断是否为空
        if (menuList != null && menuList.size() > 0) {
            //循环
            for (TreeNode treeNode : menuList) {
                //判断是否是一级菜单
                if (treeNode.getParentId() == 0) {
                    treeNode.setParentName("根节点");
                    //添加一级菜单
                    tempTreeList.add(treeNode);
                    //为菜单找子节点
                    bindChildren(treeNode, menuList);
                }
            }
        }
        return tempTreeList;
    }
}
