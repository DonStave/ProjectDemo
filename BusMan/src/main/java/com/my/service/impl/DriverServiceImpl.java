package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Driver;
import com.my.mapper.DriverMapper;
import com.my.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 司机管理业务层实现类
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverMapper driverMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String driverName) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = driverMapper.query(driverName);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Driver driver) {
        if (driver != null) {
            if (driver.getId() != null) {
                //修改
                return driverMapper.update(driver);
            } else {
                Date date = new Date();
                driver.setCreatedTime(date);
                driver.setStatus(0);
                return driverMapper.add(driver);
            }
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        return driverMapper.delete(id);
    }
}
