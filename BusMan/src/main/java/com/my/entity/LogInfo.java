package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Author: Don
 * 日志信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class LogInfo {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 日志描述
     */
    private String logDescription;

    /**
     * 日志时间
     */
    private Date logTime;
}
