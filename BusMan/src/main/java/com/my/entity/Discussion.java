package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 讨论区实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Discussion {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布人
     */
    private Integer author;

    /**
     * 状态（0正常 1删除）
     */
    private Integer status;
    /**
     * 发布时间
     */
    private Date creatTime;
}
