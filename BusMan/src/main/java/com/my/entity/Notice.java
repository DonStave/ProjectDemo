package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 通知公告实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Notice {
    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 公告新闻的内容
     */
    private String content;

    /**
     * 0:正常1过期2维护
     */
    private Integer status;

    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 新闻开始时间
     */
    private Date createdTime;

    /**
     * 新闻结束时间
     */
    private Date endTime;

    /**
     * 是否置顶（0正常 1置顶）
     */
    private Integer top;
}
