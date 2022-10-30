package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Arrange;
import com.my.mapper.ArrangeMapper;
import com.my.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 排班管理业务层实现类
 */
@Service
public class ArrangeServiceImpl implements ArrangeService {

    @Autowired
    ArrangeMapper arrangeMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String userId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = arrangeMapper.query(userId);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public PageInfo queryU(Integer currentPage, Integer pageSize, String userId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = arrangeMapper.queryU(userId);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Arrange arrange) {
        if (arrange != null) {
            if (arrange.getId() != null) {
                //修改
                return arrangeMapper.update(arrange);
            } else {
                arrange.setStaffId(1);
                arrange.setRoleId(4);
                return arrangeMapper.add(arrange);
            }
        }
        return -1;
    }

    @Override
    public int UaddOrUpdate(Arrange arrange) {
        if (arrange != null) {
            if (arrange.getId() != null) {
                //修改
                return arrangeMapper.update(arrange);
            } else {
                arrange.setStaffId(1);
                arrange.setRoleId(3);
                return arrangeMapper.add(arrange);
            }
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        return arrangeMapper.delete(id);
    }
}
