package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.BusInfo;
import com.my.service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Author: Don
 * 车辆管理控制器
 */
@RestController
@RequestMapping("/bus")
public class BusInfoController {

    @Autowired
    private BusInfoService busInfoService;



    /**
     * 分页查询车辆信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = busInfoService.query(currentPage, pageSize, search);
        return query;
    }

    /**
     * 获取所有车辆信息
     * @return
     */
    @GetMapping("/getAll")
    public List<BusInfo> getAll() {
        return busInfoService.getAllBus();
    }

    /**
     * 新增或修改车辆
     *
     * @param busInfo
     * @return
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody BusInfo busInfo) {

        return busInfoService.addOrUpdate(busInfo);
    }

    /**
     * 删除车辆信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return busInfoService.delete(id);
    }
}
