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
 * 司机实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Driver {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 司机编号
     */
    private Integer driverId;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 状态（0在岗 1下岗 2删除）
     */
    private Integer status;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT +8")
    private Date birthday;

    /**
     * 性别（0男 1女）
     */
    private Integer sex;

    /**
     * 司机地址
     */
    private String address;

    /**
     * 司机地区
     */
    private String area;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT +8")
    private Date createdTime;

    /**
     * 工作时长
     */
    private Integer workTime;

    /**
     * 公里数
     */
    private String kilometers;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 备注
     */
    private String momo;

    /**
     * 员工编号
     */
    private Integer staffId;
}
