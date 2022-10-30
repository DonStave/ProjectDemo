package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Notice;
import com.my.mapper.NoticeMapper;
import com.my.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 通知公告管理业务层实现类
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String title, String content) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = noticeMapper.query(title, content);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Notice notice) {
        if (notice != null) {
            if (notice.getId() != null) {
                //修改
                return noticeMapper.update(notice);
            } else {
                notice.setStaffId(10);
                notice.setStatus(0);
                return noticeMapper.add(notice);
            }
        }
        return -1;
    }


    @Override
    public int delete(Integer id) {
        return noticeMapper.delete(id);
    }
}
