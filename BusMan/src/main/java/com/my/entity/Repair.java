package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 维修单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Repair {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 维修原因
     */
    private String reason;

    /**
     * 维修状态（0未修理 修理中 已修理）
     */
    private Integer status;

    /**
     * 维修时间
     */
    private Date time;
}
