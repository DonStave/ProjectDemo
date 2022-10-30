package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.BusInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Don
 * 车辆管理业务层
 */
@Service
public interface BusInfoService {
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
     * 获取所有车辆信息
     *
     * @return
     */
    List<BusInfo> getAllBus();


    /**
     * 新增或者修改
     *
     * @param busInfo
     * @return
     */
    int addOrUpdate(BusInfo busInfo);


    /**
     * 删除信息
     *
     * @return
     */
    int delete(Integer id);
}
