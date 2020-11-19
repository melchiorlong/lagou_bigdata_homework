package com.lagou.dao;

import com.lagou.domain.Person;

import java.util.List;

/**
 * @author Administrator
 */
public interface PersonDao {

    List<Person> findAll();

    void save(Person person);

    Person findById(Integer id);
}
