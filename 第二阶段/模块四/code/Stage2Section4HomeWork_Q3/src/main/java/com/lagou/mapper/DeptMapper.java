package com.lagou.mapper;

import com.lagou.domain.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 */
public interface DeptMapper {

    @Select("select * from dept")
    public List<Dept> findAll();

}
