package com.my.mapper;

import com.my.entity.Discussion;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 讨论区管理mapper
 */
public interface DiscussionMapper {
    /**
     * 条件查询
     * @param title
     * @param content
     * @return
     */
    List<Map> query(@Param("title") String title, @Param("content") String content);


    /**
     * 修改讨论区信息方法
     * @return
     */
    @Update("update discussion set title=#{title},content=#{content},author=#{author},status=#{status} where id=#{id}")
    int update(Discussion discussion);

    /**
     * 新增讨论区信息
     * @return
     */
    @Insert("insert into discussion(title,content,author,creatTime,status)values(#{title},#{content},#{author},#{creatTime},#{status})")
    int add(Discussion discussion);

    /**
     * 删除讨论区信息
     * @return
     */
    @Delete("delete from discussion where id=#{id}")
    int delete(Integer id);
}
