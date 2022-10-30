package com.my.mapper;

import com.my.entity.Line;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 线路管理mapper
 */
public interface LineMapper {
    /**
     * 条件查询
     * @param lineId
     * @return
     */
    List<Map> query(String lineId);

    /**
     * 修改线路信息方法
     * @return
     */
    @Update("update line set lineId=#{lineId},route=#{route},status=#{status},site=#{site},momo=#{momo} where id=#{id}")
    int update(Line line);

    /**
     * 新增线路信息
     * @return
     */
    @Insert("insert into line(lineId,route,status,site,momo) values(#{lineId},#{route},#{status},#{site},#{momo})")
    int add(Line line);

    /**
     * 删除线路信息
     * @return
     */
    @Delete("update line set status='2' where id=#{id}")
    int delete(Integer id);
}
