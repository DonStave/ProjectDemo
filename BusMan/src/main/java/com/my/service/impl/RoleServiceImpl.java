package com.my.service.impl;

import com.my.mapper.RoleDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 角色业务层实现类
 */
@Service
@Transactional //spring声明式事务 -注解方式  aop方式
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map list(Map map) {
        int pageNo = Integer.valueOf(map.get("pageNo") + "");
        int pageSize = Integer.valueOf(map.get("pageSize") + "");
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Map> pageInfo = new PageInfo<Map>(roleDao.getList(map));
        Map rmap = new HashMap();
        rmap.put("total", pageInfo.getTotal());
        rmap.put("page", pageInfo.getList());
        return rmap;
    }

    @Override
    public int add(Map map) {
        return roleDao.add(map);
    }

    @Override
    public int update(Map map) {
        return roleDao.update(map);
    }

    @Override
    public int delete(int roleId) {
        // 删除原有角色关联的所有权限
        roleDao.deleteMenuByRoleId(roleId);
        return roleDao.delete(roleId);
    }

    @Override
    public List<Integer> listMenuByRoleId(int roleId) {
        return roleDao.listMenuByRoleId(roleId);
    }


    @Override
    public int addRoleAndMenu(int roleId, String menuIds) {
        // 删除原有角色关联的所有权限
        int r1 = roleDao.deleteMenuByRoleId(roleId);
        System.out.println("获取到的菜单ID：" + menuIds);
        int r2 = 0;
        //分割menuIds  1，2,3,100,101,103
        if (!StringUtils.isEmpty(menuIds)) {
            //roleIdsAndMenuIds = (1,1),(1,2),(1,3),(1,100),....
            StringBuffer roleIdsAndMenuIds = new StringBuffer();
            String[] midArray = menuIds.split(",");
            //循环遍历
            for (String menuId : midArray) {
                roleIdsAndMenuIds.append("(" + roleId + "," + menuId + "),");
            }
            //去掉最后一个逗号
            String tmpStr = roleIdsAndMenuIds.substring(0, roleIdsAndMenuIds.length() - 1);
            //执行添加
            r2 = roleDao.addRoleAndMenu(tmpStr);
        }
        //上面两个操作都成功，返回1
        if (r1 > 0 && r2 > 0)
            return 1;
        return 0;
    }
}
