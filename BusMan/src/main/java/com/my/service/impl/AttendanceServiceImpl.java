package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Attendance;
import com.my.mapper.AttendanceMapper;
import com.my.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 司机管理业务层实现类
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceMapper attendanceMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = attendanceMapper.query(name);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryW(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = attendanceMapper.queryW(name);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryM(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = attendanceMapper.queryM(name);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryA(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = attendanceMapper.queryA(name);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int add() {
        Attendance attendance = new Attendance();
        Calendar calendar = Calendar.getInstance();
        attendance.setClockTime(calendar.getTime());
        return attendanceMapper.add(attendance);
    }

    @Override
    public int Update(Attendance attendance) {
        if (attendance != null) {
            if (attendance.getId() != null) {
                //修改
                return attendanceMapper.update(attendance);
            }
        }
        return -1;
    }
}
