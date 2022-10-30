package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.LogInfo;
import com.my.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 日志管理控制器
 */
@RestController
@RequestMapping("/loginfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;


    /**
     * 分页查询日志信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = logInfoService.query(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改日志
     *
     * @param logInfo
     * @arrange
     */
    @PostMapping("/add")
    public int addOrUpdate(@RequestBody LogInfo logInfo) {
        return logInfoService.add(logInfo);
    }

    /**
     * 删除日志信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return logInfoService.delete(id);
    }
}
