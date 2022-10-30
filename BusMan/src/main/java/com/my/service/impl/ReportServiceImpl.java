package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.mapper.ReportMapper;
import com.my.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 日志管理业务层实现类
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Override
    public PageInfo queryVMSS(Integer currentPage, Integer pageSize, String plate) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = reportMapper.queryVMSS(plate);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryDLTS(Integer currentPage, Integer pageSize, String driverName) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = reportMapper.queryDLTS(driverName);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryLOS(Integer currentPage, Integer pageSize, String lineId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = reportMapper.queryLOS(lineId);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryCK(Integer currentPage, Integer pageSize, String plate) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = reportMapper.queryVMSS(plate);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryDK(Integer currentPage, Integer pageSize, String driverName) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = reportMapper.queryDK(driverName);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }
}
