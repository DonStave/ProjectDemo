package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Arrange;
import com.my.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 排班管理控制器
 */
@RestController
@RequestMapping("/arrange")
public class ArrangeController {

    @Autowired
    private ArrangeService arrangeService;


    /**
     * 分页查询司机排班信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = arrangeService.query(currentPage, pageSize, search);
        return query;
    }

    /**
     * 分页查询员工值班信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/queryU")
    public PageInfo queryU(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = arrangeService.queryU(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改司机排班
     *
     * @param arrange
     * @arrange
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Arrange arrange) {
        return arrangeService.addOrUpdate(arrange);
    }
    /**
     * 新增或修改员工排班
     *
     * @param arrange
     * @arrange
     */
    @PostMapping("/UaddOrUpdate")
    public int UaddOrUpdate(@RequestBody Arrange arrange) {
        return arrangeService.UaddOrUpdate(arrange);
    }

    /**
     * 删除排班信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return arrangeService.delete(id);
    }
}
