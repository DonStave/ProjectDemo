package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Discussion;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 讨论区管理业务层
 */
@Service
public interface DiscussionService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param title
     * @param content
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String title, String content);


    /**
     * 新增或者修改
     *
     * @param discussion
     * @return
     */
    int addOrUpdate(Discussion discussion);


    /**
     * 删除信息
     *
     * @return
     */
    int delete(Integer id);
}
