package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Driver;
import com.my.mapper.DriverMapper;
import com.my.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Author: Don
 * 司机管理控制器
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverMapper driverMapper;


    /**
     * 分页查询所有司机信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = driverService.query(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改司机信息
     *
     * @param driver
     * @return
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Driver driver) {
        return driverService.addOrUpdate(driver);
    }

    /**
     * 删除司机信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return driverService.delete(id);
    }

    /**
     * 查询司机列表
     * @return
     */
    @GetMapping("/queryAll")
    public List<Driver> queryAll() {
        return driverMapper.queryAll();
    }
}
