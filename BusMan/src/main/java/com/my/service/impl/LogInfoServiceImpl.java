package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.LogInfo;
import com.my.mapper.LogInfoMapper;
import com.my.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 日志管理业务层实现类
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    LogInfoMapper logInfoMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String logName) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = logInfoMapper.query(logName);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int add(LogInfo logInfo) {
        if (logInfo != null) {
            Date date = new Date();
            logInfo.setLogTime(date);
            return logInfoMapper.add(logInfo);

        }
        return -1;
    }


    @Override
    public int delete(Integer id) {
        return logInfoMapper.delete(id);
    }
}
