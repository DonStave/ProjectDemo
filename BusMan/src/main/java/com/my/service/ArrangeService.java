package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Arrange;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 排班管理业务层
 */
@Service
public interface ArrangeService {
    /**
     * 分页按条件查询司机排班
     *
     * @param currentPage
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String userId);

    /**
     * 分页按条件查询员工排班
     *
     * @param currentPage
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo queryU(Integer currentPage, Integer pageSize, String userId);

    /**
     * 新增或者修改
     *
     * @param arrange
     * @return
     */
    int addOrUpdate(Arrange arrange);

    /**
     * 新增或者修改
     *
     * @param arrange
     * @return
     */
    int UaddOrUpdate(Arrange arrange);

    /**
     * 删除信息
     *
     * @return
     */
    int delete(Integer id);
}
