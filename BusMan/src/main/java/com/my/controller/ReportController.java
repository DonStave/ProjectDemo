package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 报表控制器
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;


    /**
     * 车辆里程汇总统计
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryVMSS")
    public PageInfo queryVMSS(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = reportService.queryVMSS(currentPage, pageSize, search);
        return query;
    }

    /**
     * 司机运行时长统计
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryDLTS")
    public PageInfo queryDLTS(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = reportService.queryDLTS(currentPage, pageSize, search);
        return query;
    }
    /**
     * 线路运营汇总
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryLOS")
    public PageInfo queryLOS(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = reportService.queryLOS(currentPage, pageSize, search);
        return query;
    }

    /**
     * 汽车公里数
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryCK")
    public PageInfo queryCK(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = reportService.queryCK(currentPage, pageSize, search);
        return query;
    }
    /**
     * 司机公里数
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryDK")
    public PageInfo queryDK(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = reportService.queryDK(currentPage, pageSize, search);
        return query;
    }


}
