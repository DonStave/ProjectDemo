package com.my.mapper;

import com.my.entity.BusInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 车辆管理mapper
 */
public interface BusMapper {
    /**
     * 条件查询
     * @param plate
     * @return
     */
    List<Map> query(String plate);

    /**
     * 加载所有车辆信息
     * @return
     */
    @Select("select * from businfo")
    List<BusInfo> getAll();
    /**
     * 修改车辆信息方法
     * @return
     */
    @Update("update businfo set plate=#{plate},status=#{status},kilometers=#{kilometers} where id=#{id}")
    int update(BusInfo busInfo);

    /**
     * 新增车辆信息
     * @return
     */
    @Insert("insert into businfo(plate,status,kilometers)value(#{plate},#{status},#{kilometers})")
    int add(BusInfo busInfo);

    /**
     * 删除车辆信息
     * @return
     */
    @Delete("delete from businfo where id=#{id}")
    int delete(Integer id);
}
