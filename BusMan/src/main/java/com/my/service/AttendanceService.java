package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Attendance;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 考勤管理业务层
 */
@Service
public interface AttendanceService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String name);

    /**
     * 一周
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo queryW(Integer currentPage, Integer pageSize, String name);

    /**
     * 一个月
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo queryM(Integer currentPage, Integer pageSize, String name);

    /**
     * 所有考勤信息
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo queryA(Integer currentPage, Integer pageSize, String name);

    /**
     * 修改
     *
     * @param attendance
     * @return
     */
    int Update(Attendance attendance);

    /**
     * 新增
     *
     * @return
     */
    int add();
}
