package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Author: Don
 * 线路信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Line {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 线路编号
     */
    private String lineId;

    /**
     * 线路区间
     */
    private String route;

    /**
     * 状态（0启用 1暂停使用 2删除）
     */
    private Integer status;

    /**
     * 途经站点名称
     */
    private String site;

    /**
     * 备注
     */
    private String momo;
}
