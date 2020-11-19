package com.lagou.service;

import com.lagou.domain.Person;

import java.util.List;

/**
 * @author Administrator
 */
public interface PersonService {

    List<Person> findAll();

    void save(Person person);

    Person findById(Integer personId);
}
