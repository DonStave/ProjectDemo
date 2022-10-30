package com.my.mapper;

import com.my.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Don
 * 角色管理Mapper
 */
public interface RoleDao {

    /**
     * 列表
     * @return
     */
    @Select("<script>select role_id, role_name, status,create_by, date_format(create_time,'%Y-%m-%d %H:%i:%S') create_time, update_by, update_time, remark from sys_role where del_flag=0 " +
            "<if test=\"roleName!=null and roleName!=''\"> and role_name like concat('%',#{roleName},'%')</if>" +
            "</script>")
    List<Map> getList(Map map);

    /**
     * 查询所有角色信息
     * @return
     */
    @Select("select * from sys_role")
    List<Role> getAll();

    /**
     * 根据角色查询该角色拥有的所有权限id
     * @param roleId
     * @return
     */
    @Select("select menu_id from sys_role_menu where role_id=#{roleId}")
    List<Integer> listMenuByRoleId(int roleId);

    /**
     * 根据角色ID删除当前角色关联的所有权限
     * @param roleId
     * @return
     */
    @Delete("delete from sys_role_menu where role_id=#{roleId}")
    int deleteMenuByRoleId(int roleId);

    /**
     * 添加角色权限关联数据
     * $和#有什么区别
     * @param roleIdsAndMenuIds
     * @return
     */
    @Insert("insert into sys_role_menu values ${roleIdsAndMenuIds}")  //$ 一定使用 如果#,报错
    int addRoleAndMenu(String roleIdsAndMenuIds);
    /***
     * 权限菜单添加
     * @param map
     * @return
     */
    @Insert("insert into sys_role (role_name,role_key,role_sort,status,create_by, create_time, update_by, update_time) VALUES " +
                                  "(#{role_name},'default',1,#{status},#{userName},now(),#{userName},  now())")
    int add(Map map);

    /**
     * 更新
     * @param map
     * @return
     */
    @Update("update sys_role set role_name=#{role_name}, status=#{status}, update_by=#{userName}, update_time=now() " +
            " where role_id=#{role_id}")
    int update(Map map);

    /**
     * 删除
     * @param roleId
     * @return
     */
    @Delete("delete from sys_role where role_id=#{roleId}")
    int delete(int roleId);
}
