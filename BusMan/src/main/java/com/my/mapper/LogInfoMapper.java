package com.my.mapper;

import com.my.entity.LogInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 日志管理mapper
 */
public interface LogInfoMapper {
    /**
     * 条件查询
     * @param logName
     * @return
     */
    List<Map> query( String logName);


    /**
     * 新增日志信息
     * @return
     */
    @Insert("insert into loginfo(logName,logDescription,logTime)values(#{logName},#{logDescription},#{logTime})")
    int add(LogInfo logInfo);

    /**
     * 删除日志信息
     * @return
     */
    @Delete("delete from  loginfo  where id=#{id}")
    int delete(Integer id);
}
