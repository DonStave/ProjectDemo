package com.my.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 员工实体类
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Staff {
    /**
     * id
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 员工电话
     */
    private String phone;

    /**
     * 员工身份证号码
     */
    private String idCard;

    /**
     * 员工地址
     */
    private String address;

    /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT +8")
    private String createdTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT +8")
    private String endTime;
    /**
     * 员工状态(1.在职 2.离职 3.黑名单)
     */
    private Integer status;

    /**
     * roleid
     */
    private Integer roleId;
    /**
     * 角色名字
     */
    private String roleName;

    /**
     * 备注
     */
    private String momo;

}
