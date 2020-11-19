package com.lagou.service.impl;

import com.lagou.dao.PersonDao;
import com.lagou.domain.Person;
import com.lagou.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Override
    public List<Person> findAll() {
        List<Person> personList = personDao.findAll();
        return personList;
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public Person findById(Integer personId) {
        return personDao.findById(personId);
    }
}
