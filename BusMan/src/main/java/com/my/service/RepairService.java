package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Repair;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 维修单管理业务层
 */
@Service
public interface RepairService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param plate
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String plate);


    /**
     * 新增或者修改
     *
     * @param repair
     * @return
     */
    int addOrUpdate(Repair repair);


    /**
     * 删除信息
     *
     * @return
     */
    int delete(Integer id);
}
