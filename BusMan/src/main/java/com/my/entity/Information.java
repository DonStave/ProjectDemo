package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Author: Don
 * 资料实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Information {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 资料名称
     */
    private String infoName;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String momo;

    /**
     * 员工id
     */
    private Integer staffId;
}
