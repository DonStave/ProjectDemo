package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Repair;
import com.my.mapper.RepairMapper;
import com.my.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 维修单管理业务层实现类
 */
@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    RepairMapper repairMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String userId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = repairMapper.query(userId);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }


    @Override
    public int addOrUpdate(Repair repair) {
        if (repair != null) {
            Calendar calendar = Calendar.getInstance();
            repair.setTime(calendar.getTime());
            if (repair.getId() != null) {
                //修改
                return repairMapper.update(repair);
            } else {
                return repairMapper.add(repair);
            }
        }
        return -1;
    }


    @Override
    public int delete(Integer id) {
        return repairMapper.delete(id);
    }
}
