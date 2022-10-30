package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Repair;
import com.my.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Author: Don
 * 维修单管理控制器
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;



    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = repairService.query(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改维修单
     *
     * @param repair
     * @arrange
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Repair repair) {
        return repairService.addOrUpdate(repair);
    }


    /**
     * 删除维修单信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return repairService.delete(id);
    }
}
