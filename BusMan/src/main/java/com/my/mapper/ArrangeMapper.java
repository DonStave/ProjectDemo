package com.my.mapper;

import com.my.entity.Arrange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 排班管理mapper
 */
public interface ArrangeMapper {
    /**
     * 条件查询
     * @param userId
     * @return
     */
    List<Map> query(String userId);
    /**
     * 条件查询
     * @param userId
     * @return
     */
    List<Map> queryU(String userId);

    /**
     * 修改排班信息方法
     * @return
     */
    @Update("update arrange set userId=#{userId},startTime=#{startTime},endTime=#{endTime},staffId=#{staffId} where id=#{id}")
    int update(Arrange arrange);

    /**
     * 新增排班信息
     * @return
     */
    @Insert("insert into arrange(userId,startTime,endTime,roleId,staffId) values(#{userId},#{startTime},#{endTime},#{roleId},#{staffId})")
    int add(Arrange arrange);

    /**
     * 删除排班信息
     * @return
     */
    @Delete("delete from  arrange  where id=#{id}")
    int delete(Integer id);
}
