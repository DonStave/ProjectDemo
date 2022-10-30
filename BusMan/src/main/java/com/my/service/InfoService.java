package com.my.service;

import com.github.pagehelper.PageInfo;
import com.my.entity.Information;
import org.springframework.stereotype.Service;

/**
 * Author: Don
 * 资料管理业务层
 */
@Service
public interface InfoService {
    /**
     * 分页按条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param infoName
     * @return
     */
    PageInfo query(Integer currentPage, Integer pageSize, String infoName);

    /**
     * 新增或者修改
     *
     * @param information
     * @return
     */
    int addOrUpdate(Information information);

    /**
     * 删除员工信息
     *
     * @return
     */
    int delete(Integer id);
}
