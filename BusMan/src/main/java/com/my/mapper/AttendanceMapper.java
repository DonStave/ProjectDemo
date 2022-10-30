package com.my.mapper;

import com.my.entity.Attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 考勤管理实体类
 */
public interface AttendanceMapper {
    /**
     * 条件查询考勤信息
     * @param name
     * @return
     */
    List<Map> query(String name);

    /**
     * 查询一周以内考勤信息
     * @param name
     * @return
     */
    List<Map> queryW(String name);

    /**
     * 查询一月以内考勤信息
     * @param name
     * @return
     */
    List<Map> queryM(String name);
    /**
     * 查询所有考勤信息
     * @param name
     * @return
     */
    List<Map> queryA(String name);

    /**
     * 修改考勤信息
     * @return
     */
    @Update("update attendance set clockTime=#{clockTime},status=#{status} where id = #{id}")
    int update(Attendance attendance);

    /**
     * 新增考勤信息
     * @return
     */
    @Insert("insert into attendance(name,phone,idCard,clockTime,status) values('许少东','15138681904','411381199709121516',#{clockTime},0)")
    int add(Attendance attendance);


}
