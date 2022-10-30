package com.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.Information;
import com.my.mapper.InformationMapper;
import com.my.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Don
 * 资料管理业务层实现类
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    InformationMapper informationMapper;

    @Override
    public PageInfo query(Integer currentPage, Integer pageSize, String infoName) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map> query = informationMapper.query(infoName);
        PageInfo<Map> info = new PageInfo<>(query, pageSize);
        return info;
    }

    @Override
    public int addOrUpdate(Information information) {
        if (information != null) {
            if (information.getId() != null) {
                //修改
                return informationMapper.update(information);
            } else {
                return informationMapper.add(information);
            }
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        return informationMapper.delete(id);
    }
}
