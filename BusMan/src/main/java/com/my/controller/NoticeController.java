package com.my.controller;

import com.github.pagehelper.PageInfo;
import com.my.entity.Notice;
import com.my.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Don
 * 通知管理管理控制器
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    /**
     * 分页查询公告信息
     * @param currentPage
     * @param pageSize
     * @param search1
     * @param search2
     * @return
     */
    @GetMapping("/query")
    public PageInfo query(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, String search1,String search2) {
        PageInfo query = noticeService.query(currentPage, pageSize, search1,search2);
        return query;
    }



    /**
     * 新增或修改
     *
     * @param notice
     * @arrange
     */
    @PostMapping("/addOrUpdate")
    public int addOrUpdate(@RequestBody Notice notice) {
        return noticeService.addOrUpdate(notice);
    }

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public int delete(Integer id) {
        return noticeService.delete(id);
    }
}
