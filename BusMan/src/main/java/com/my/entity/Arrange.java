package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 排班信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Arrange {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 员工/司机编号
     */
    private Integer userId;

    /**
     * 排班开始时间
     */
    private Date startTime;

    /**
     * 排班结束时间
     */
    private Date endTime;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 员工编号
     */
    private Integer staffId;
}
