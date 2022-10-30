package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Discussion;
import com.my.mapper.DiscussionMapper;
import com.my.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 通知公告管理业务层实现类
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    DiscussionMapper discussionMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String title, String content) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = discussionMapper.query(title, content);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Discussion discussion) {
        if (discussion != null) {
            if (discussion.getId() != null) {
                //修改
                return discussionMapper.update(discussion);
            } else {
                Calendar calendar = Calendar.getInstance();
                discussion.setCreatTime(calendar.getTime());
                discussion.setAuthor(10);
                discussion.setStatus(0);
                return discussionMapper.add(discussion);
            }
        }
        return -1;
    }


    @Override
    public int delete(Integer id) {
        return discussionMapper.delete(id);
    }
}
