package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Information;
import com.my.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Author: Don
 * 资料管理控制器
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;



    /**
     * 分页查询资料信息
     *
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search) {
        PageInfo query = infoService.query(currentPage, pageSize, search);
        return query;
    }


    /**
     * 新增或修改资料信息
     *
     * @param information
     * @return
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Information information) {
        return infoService.addOrUpdate(information);
    }

    /**
     * 删除资料信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return infoService.delete(id);
    }
}
