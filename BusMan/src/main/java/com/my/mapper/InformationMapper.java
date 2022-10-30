package com.my.mapper;

import com.my.entity.Information;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 资料操作Mapper
 */
public interface InformationMapper {
    /**
     * 条件查询
     * @param infoName
     * @return
     */
    List<Map> query(String infoName);

    /**
     * 修改资料信息方法
     * @return
     */
    @Update("update information set infoName=#{infoName},description=#{description},momo=#{momo},staffId='1' where id=#{id}")
    int update(Information information);

    /**
     * 新增资料信息
     * @return
     */
    @Insert("insert into information(infoName,description,momo,staffId) values(#{infoName},#{description},#{momo},'1')")
    int add(Information information);

    /**
     * 删除资料信息
     * @return
     */
    @Delete("delete from information where id=#{id}")
    int delete(Integer id);
}
