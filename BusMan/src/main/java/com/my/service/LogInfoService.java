package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.LogInfo;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 日志管理业务层
 */
@Service
public interface LogInfoService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param logName
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String logName);


    /**
     * 新增
     *
     * @param logInfo
     * @return
     */
    int add(LogInfo logInfo);


    /**
     * 删除信息
     *
     * @return
     */
    int delete(Integer id);
}
