package com.my.mapper;

import com.my.entity.Arrange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 排班管理mapper
 */
public interface ReportMapper {
    /**
     * 车辆里程汇总统计
     * @param plate
     * @return
     */
    List<Map> queryVMSS(String plate);

    /**
     * 司机运行时长统计
     * @param driverName
     * @return
     */
    List<Map> queryDLTS(String driverName);

    /**
     * 线路运营汇总
     * @param lineId
     * @return
     */
    List<Map> queryLOS(String lineId);
    /**
     * 汽车公里数
     * @param plate
     * @return
     */
    List<Map> queryCK(String plate);

    /**
     * 司机公里数
     * @param driverName
     * @return
     */
    List<Map> queryDK(String driverName);


}
