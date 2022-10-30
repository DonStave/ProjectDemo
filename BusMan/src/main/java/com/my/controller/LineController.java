package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Line;
import com.my.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 线路管理控制器
 */
@RestController
@RequestMapping("/line")
public class LineController {

    @Autowired
    private LineService lineService;



    /**
     * 分页查询线路信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = lineService.query(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改线路
     *
     * @param line
     * @return
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Line line) {
        return lineService.addOrUpdate(line);
    }

    /**
     * 删除线路信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return lineService.delete(id);
    }
}
