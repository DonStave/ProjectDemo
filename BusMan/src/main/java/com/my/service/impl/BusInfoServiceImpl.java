package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.BusInfo;
import com.my.mapper.BusMapper;
import com.my.service.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 车辆管理业务层实现类
 */
@Service
public class BusInfoServiceImpl implements BusInfoService {

    @Autowired
    BusMapper busMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String plate) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = busMapper.query(plate);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public List<BusInfo> getAllBus() {
        return busMapper.getAll();
    }

    @Override
    public int addOrUpdate(BusInfo busInfo) {
        if (busInfo != null) {
            if (busInfo.getId() != null) {
                //修改
                return busMapper.update(busInfo);
            } else {
                busInfo.setStatus(0);
                busInfo.setKilometers(0);
                return busMapper.add(busInfo);
            }
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        return busMapper.delete(id);
    }
}
