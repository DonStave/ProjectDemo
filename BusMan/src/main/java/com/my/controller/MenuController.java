package com.my.controller;

import com.my.service.MenuService;
import com.my.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Author: Don
 * 菜单控制器
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取树形菜单数据
     *
     * @return
     */
    @RequestMapping("tree")
    public Object getTree() {
        return menuService.getTreeData();
    }

    /***
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("add")
    public Object add(@RequestBody Map map) {
        return menuService.add(map);
    }

    ;

    /**
     * 更新
     *
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestBody Map map) {
        return menuService.update(map);
    }

    ;

    /**
     * 删除
     *
     * @param menuId
     * @return
     */
    @RequestMapping("delete")
    public Object delete(int menuId) {
        return menuService.delete(menuId);
    }



    /**
     * 根据登录用户id查询该用户对象的所有权限菜单#{userId}
     *
     * @return
     */
    @RequestMapping("listMenuByUserId")
    public Object listMenuByUserId(HttpSession session) {
        return menuService.listMenuByUserId(SessionUtil.getUserId());
    }
}
