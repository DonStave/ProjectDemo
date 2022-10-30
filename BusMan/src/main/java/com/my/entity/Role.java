package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 角色信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Role {
    /**
     * 角色id
     */
    private Integer role_id;

    /**
     * 角色名称
     */
    private String role_name;

    /**
     * 角色权限字符串
     */
    private String role_key;

    /**
     * 显示顺序
     */
    private Integer role_sort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限）
     */
    private String data_scope;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String del_flag;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新者
     */
    private String update_by;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 备注
     */
    private String remark;
}
