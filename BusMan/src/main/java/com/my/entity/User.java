package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 部门id
     */
    private Integer dept_id;

    /**
     * 登录账号
     */
    private String login_name;

    /**
     * 用户昵称
     */
    private String user_name;

    /**
     * 用户类型（00系统用户）
     */
    private String user_type;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String del_flag;

    /**
     * 最后登陆ip
     */
    private String login_ip;

    /**
     * 最后登陆时间
     */
    private Date login_date;

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

    /**
     * role_id
     */
    private Integer role_id;
}
