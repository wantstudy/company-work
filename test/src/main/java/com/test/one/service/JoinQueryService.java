package com.test.one.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.one.bean.Person;
import com.test.one.bean.School;

@Service
public class JoinQueryService {

    @Autowired
    private PersonService personService;

    @Autowired
    private SchoolService schoolService;

    @Cacheable(value = {"Person", "School"})
    public List queryPersonAndSchool(int id) {
        System.out.println("queryPersonAndSchool");
        List list = new ArrayList<Object>();

        Person person = personService.getPerson(id);
        School school = schoolService.getSchool(id);
        if (person != null)
            list.add(person);
        if (school != null)
            list.add(school);
        return list;
    }
}
