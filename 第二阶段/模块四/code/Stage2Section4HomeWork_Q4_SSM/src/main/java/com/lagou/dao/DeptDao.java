package com.lagou.dao;

import com.lagou.domain.Dept;

import java.util.List;

/**
 * @author Administrator
 */
public interface DeptDao {

    List<Dept> findAll();

}
