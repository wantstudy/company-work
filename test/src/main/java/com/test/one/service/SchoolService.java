package com.test.one.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.test.one.bean.School;

@Service
public class SchoolService {


    private static Map<Integer, School> schoolMap = new HashMap<Integer, School>();

    static {
        School school = new School();
        school.setId(1);
        school.setSchoolName("1小");

        School school2 = new School();
        school2.setId(2);
        school2.setSchoolName("2小");

        School school3 = new School();
        school3.setId(3);
        school3.setSchoolName("3小");

        School school4 = new School();
        school4.setId(4);
        school4.setSchoolName("4小");


        schoolMap.put(1, school);
        schoolMap.put(2, school2);
        schoolMap.put(3, school3);
        schoolMap.put(4, school4);

    }

    @Cacheable("School")
    public School getSchool(int id) {
        System.out.println("cache not find,use source,id :" + id);

        return schoolMap.get(id);
    }

    @CachePut(value = "School", key = "#id")
    @CacheEvict(cacheNames = "tancehuancun", allEntries = true)
    public School updateSchool(int id, String name) {
        System.out.println("update School,id " + id);
        School school = schoolMap.get(id);
        school.setSchoolName(name);
        schoolMap.put(id, school);
        return school;
    }

    @Caching(
            evict = {
                    @CacheEvict("School"),
                    @CacheEvict(cacheNames = "tancehuancun", allEntries = true)
            }
    )
    public void deleteSchool(int id) {
        System.out.println("delect School id: " + id);
        schoolMap.remove(id);
    }

    @CachePut(value = "School", key = "#id")
    @CacheEvict(cacheNames = "tancehuancun", allEntries = true)
    public School addSchool(int id, String name) {
        System.out.println("add School");
        School School = new School();
        School.setId(id);

        schoolMap.put(id, School);
        return School;
    }
}
