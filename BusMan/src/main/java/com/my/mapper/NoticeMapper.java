package com.my.mapper;

import com.my.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 通知公告管理mapper
 */
public interface NoticeMapper {
    /**
     * 条件查询
     * @param title
     * @param content
     * @return
     */
    List<Map> query(@Param("title") String title, @Param("content") String content);


    /**
     * 修改通知公告信息方法
     * @return
     */
    @Update("update notice set title=#{title},content=#{content},status=#{status},endTime=#{endTime},top=#{top} where id=#{id}")
    int update(Notice notice);

    /**
     * 新增通知公告信息
     * @return
     */
    @Insert("insert into notice(title,content,status,staffId,createdTime,endTime,top) values(#{title},#{content},#{status},#{staffId},#{createdTime},#{endTime},#{top})")
    int add(Notice notice);

    /**
     * 删除通知公告信息
     * @return
     */
    @Delete("delete from  arrange  where id=#{id}")
    int delete(Integer id);
}
