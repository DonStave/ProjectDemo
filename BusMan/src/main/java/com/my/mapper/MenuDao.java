package com.my.mapper;

import com.my.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 菜单加载
 */
public interface MenuDao {

    /**
     * 根据登录用户id查询该用户对象的所有权限菜单
     *
     -- 根据用户id查询出该用户对应的角色ID
     select  role_id from sys_user_role where user_id=1
     -- 再根据角色ID查询出该用户对应的权限菜单ID
     select menu_id from sys_role_menu  where role_id in(上一步的执行结果);
     -- 再根据权限菜单id集合查询出该用户对应的权限
     select * from sys_menu where menu_id in(上一步的执行结果);

     -- 最后语句  in
     select * from sys_menu where menu_id in(
     select menu_id from sys_role_menu  where role_id in(
     select  role_id from sys_user_role where user_id=1
     )
     );
     -- 优化写法  in 改为存在 EXISTS
     select * from sys_menu t where exists(
     select 1 from sys_role_menu t1 where exists (
     select  1 from sys_user_role t2 where user_id=1
     and t2.role_id=t1.role_id
     ) and t1.menu_id = t.menu_id
     );
     * @param userId
     * @return
     */
    @Select("select menu_id id,menu_name as label,url,parent_id  parentId,icon from sys_menu t where exists(" +
            "     select 1 from sys_role_menu t1 where exists (" +
            "     select  1 from sys_user_role t2 where user_id=#{userId}" +
            "     and t2.role_id=t1.role_id" +
            "     ) and t1.menu_id = t.menu_id" +
            "     )")
    List<TreeNode> listMenuByUserId(int userId);
    /**
     * 权限（菜单）列表
     * @return
     */
    @Select("select menu_id id,menu_name as label,url,parent_id  parentId,icon from sys_menu where visible=0")
    List<TreeNode> getList();


    /***
     * 权限菜单添加
     * @param map
     * @return
     */
    @Insert("insert into sys_menu (menu_name, parent_id,  url,  visible,icon, create_by, create_time, update_by, update_time) VALUES " +
                                  "(#{label}, #{parentId},#{url},#{visible},#{icon}, #{userName}, now(), #{userName}, now())")
    int add(Map map);

    /**
     * 更新
     * @param map
     * @return
     */
    @Update("update sys_menu set menu_name=#{label}, parent_id=#{parentId},  url=#{url},  visible=#{visible},icon=#{icon}, " +
            "update_by=#{userName}, update_time=now() where menu_id=#{id}")
    int update(Map map);

    /**
     * 删除
     * @param menuId
     * @return
     */
    @Delete("delete from sys_menu where menu_id=#{menuId}")
    int delete(int menuId);
}
