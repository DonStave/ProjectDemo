package com.my.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 考勤管理实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Attendance {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工或者司机姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 打卡时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT +8")
    private Date clockTime;

    /**
     * 状态
     */
    private Integer status;
}
