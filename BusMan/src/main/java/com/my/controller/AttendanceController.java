package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Attendance;
import com.my.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 考勤管理控制器
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    /**
     * 分页查询当天考勤信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = attendanceService.query(currentPage, pageSize, search);
        return query;
    }

    /**
     * 分页查询本周考勤信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryW")
    public PageInfo queryW(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = attendanceService.queryW(currentPage, pageSize, search);
        return query;
    }
    /**
     * 分页查询本月考勤信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryM")
    public PageInfo queryM(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = attendanceService.queryM(currentPage, pageSize, search);
        return query;
    }

    /**
     * 分页查询所有考勤信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryA")
    public PageInfo queryA(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = attendanceService.queryA(currentPage, pageSize, search);
        return query;
    }

    /**
     * 修改考勤信息
     *
     * @param attendance
     * @return
     */
    @PostMapping("/Update")
    public int Update(@RequestBody Attendance attendance) {
        return attendanceService.Update(attendance);
    }


    /**
     * 新增考勤
     *
     * @return
     */
    @PostMapping("/add")
    public int add() {
        return attendanceService.add();
    }

}
