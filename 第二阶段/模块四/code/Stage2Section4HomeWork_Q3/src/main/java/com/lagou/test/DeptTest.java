package com.lagou.test;

import com.lagou.domain.Dept;
import com.lagou.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 */
public class DeptTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testSelect() throws IOException {
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.findAll();

        for (Dept dept : depts) {
            System.out.println("dept = " + dept);
        }
    }

}
