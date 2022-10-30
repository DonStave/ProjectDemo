package com.my.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 报表管理业务层
 */
@Service
public interface ReportService {
    /**
     * 车辆里程汇总统计
     *
     * @param currentPage
     * @param pageSize
     * @param plate
     * @return
     */
    PageInfo queryVMSS(Integer currentPage, Integer pageSize, String plate);

    /**
     * 司机运行时长统计
     *
     * @param currentPage
     * @param pageSize
     * @param driverName
     * @return
     */
    PageInfo queryDLTS(Integer currentPage, Integer pageSize, String driverName);

    /**
     * 线路运营汇总
     *
     * @param currentPage
     * @param pageSize
     * @param lineId
     * @return
     */
    PageInfo queryLOS(Integer currentPage, Integer pageSize, String lineId);

    /**
     * 汽车公里数
     *
     * @param currentPage
     * @param pageSize
     * @param plate
     * @return
     */
    PageInfo queryCK(Integer currentPage, Integer pageSize, String plate);

    /**
     * 司机公里数
     *
     * @param currentPage
     * @param pageSize
     * @param driverName
     * @return
     */
    PageInfo queryDK(Integer currentPage, Integer pageSize, String driverName);


}
