package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 *Author: Don
 * 车辆信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class BusInfo {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 状态（0正常 1故障 2废弃）
     */
    private Integer status;

    /**
     * 车辆里程数
     */
    private Integer kilometers;
}
