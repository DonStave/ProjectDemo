package com.my.mapper;

import com.my.entity.Driver;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 司机管理mapper
 */
public interface DriverMapper {
    /**
     * 条件查询
     * @param driverName
     * @return
     */
    List<Map> query(String driverName);

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from driver")
    List<Driver> queryAll();
    /**
     * 修改司机信息方法
     * @return
     */
    @Update("update driver set driverId=#{driverId},driverName=#{driverName},phone=#{phone},status=#{status},idCard=#{idCard},birthday=#{birthday},sex=#{sex},address=#{address},area=#{area},createdTime=#{createdTime},workTime=#{workTime},kilometers=#{kilometers},plate=#{plate},momo=#{momo},staffId='1' where id=#{id}")
    int update(Driver driver);

    /**
     * 新增司机信息
     * @return
     */
    @Insert("insert into driver(driverId,driverName,phone,status,idCard,birthday,sex,address,area,createdTime,workTime,kilometers,plate,momo,staffId) values(#{driverId},#{driverName},#{phone},#{status},#{idCard},#{birthday},#{sex},#{address},#{area},#{createdTime},#{workTime},#{kilometers},#{plate},#{momo},#{staffId})")
    int add(Driver driver);

    /**
     * 删除司机信息
     * @return
     */
    @Delete("update driver set status='2' where id=#{id}")
    int delete(Integer id);
}
