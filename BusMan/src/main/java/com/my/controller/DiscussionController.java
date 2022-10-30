package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Discussion;
import com.my.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 讨论区管理控制器
 */
@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;


    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param search1
     * @param search2
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search1,String search2) {
        PageInfo query = discussionService.query(currentPage, pageSize, search1,search2);
        return query;
    }



    /**
     * 新增或修改
     *
     * @param discussion
     * @arrange
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Discussion discussion) {
        return discussionService.addOrUpdate(discussion);
    }

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return discussionService.delete(id);
    }
}
