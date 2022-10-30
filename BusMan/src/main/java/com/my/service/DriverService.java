package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Driver;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 司机管理业务层
 */
@Service
public interface DriverService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param driverName
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String driverName);

    /**
     * 新增或者修改
     *
     * @param driver
     * @return
     */
    int addOrUpdate(Driver driver);

    /**
     * 删除员工信息
     *
     * @return
     */
    int delete(Integer id);
}
