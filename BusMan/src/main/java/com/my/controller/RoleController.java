package com.my.controller;

import com.my.entity.Role;
import com.my.mapper.RoleDao;
import com.my.service.RoleService;
import com.my.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 角色管理控制器
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleDao roleDao;

    /**
     * 列表
     * @return
     */
    @RequestMapping("page")
   public Object list(@RequestParam Map map){
       return roleService.list(map);
    }

    /***
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("add")
    public Object add(@RequestBody  Map map, HttpSession session){
        map.put("userName", SessionUtil.getUserName());
        return roleService.add(map);
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestBody  Map map, HttpSession session){
        map.put("userName", SessionUtil.getUserName());
        return roleService.update(map);
    }

    /**
     * 删除
     * @param roleId
     * @return
     */
    @RequestMapping("delete")
    public Object delete(int roleId){
        return roleService.delete(roleId);
    }


    /**
     * 根据角色查询该角色拥有的所有权限id
     * @param roleId
     * @return
     */
    @RequestMapping("listMenuByRoleId")
    public List<Integer> listMenuByRoleId(int roleId){
        return roleService.listMenuByRoleId(roleId);
    }



    /**
     * 添加角色权限关联数据
     * @param roleId
     * @param menuIds
     * @return
     */
    @RequestMapping("addRoleAndMenu")
    public Object addRoleAndMenu(Integer roleId,String menuIds){
        return roleService.addRoleAndMenu(roleId,menuIds);
    }

    /**
     * 加载角色列表
     * @return
     */
    @GetMapping("getAll")
    public List<Role> getAll() {
        return roleDao.getAll();
    }
}
