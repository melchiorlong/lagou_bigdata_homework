package com.lagou.service.impl;

import com.lagou.dao.DeptDao;
import com.lagou.domain.Dept;
import com.lagou.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public List<Dept> findAll() {
        List<Dept> deptList = deptDao.findAll();
        return deptList;
    }
}
