package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Line;
import com.my.mapper.LineMapper;
import com.my.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 线路管理业务层实现类
 */
@Service
public class LineServiceImpl implements LineService {

    @Autowired
    LineMapper lineMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String lineId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = lineMapper.query(lineId);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Line line) {
        if (line != null) {
            if (line.getId() != null) {
                //修改
                return lineMapper.update(line);
            } else {
                line.setStatus(0);
                return lineMapper.add(line);
            }
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        return lineMapper.delete(id);
    }
}
