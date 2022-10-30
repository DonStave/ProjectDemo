package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Line;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 线路管理业务层
 */
@Service
public interface LineService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param lineId
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String lineId);

    /**
     * 新增或者修改
     *
     * @param line
     * @return
     */
    int addOrUpdate(Line line);

    /**
     * 删除员工信息
     *
     * @return
     */
    int delete(Integer id);
}
