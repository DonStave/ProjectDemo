package com.my.mapper;

import com.my.entity.Repair;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 维修单实体类
 */
public interface RepairMapper {
    /**
     * 条件查询
     * @param plate
     * @return
     */
    List<Map> query(String plate);


    /**
     * 修改考勤信息
     * @return
     */
    @Update("update repair set plate=#{plate},reason=#{reason},status=#{status},time=#{time} where id=#{id}")
    int update(Repair repair);

    /**
     * 新增考勤信息
     * @return
     */
    @Insert("insert into repair(plate,reason,status,time)values(#{plate},#{reason},#{status},#{time})")
    int add(Repair repair);

    /**
     * 删除维修单
     * @return
     */
    @Delete("delete from  repair  where id=#{id}")
    int delete(Integer id);
}
