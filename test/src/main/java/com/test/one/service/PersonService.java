package com.test.one.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.test.one.bean.Person;

@Service
public class PersonService {

    private static Map<Integer, Person> personMap = new HashMap<Integer, Person>();

    static {
        Person person = new Person();
        person.setId(1);
        person.setPersonAge(1);
        person.setPersonName("小1");

        Person person2 = new Person();
        person2.setId(2);
        person2.setPersonAge(2);
        person2.setPersonName("小2");

        Person person3 = new Person();
        person3.setId(3);
        person3.setPersonAge(3);
        person3.setPersonName("小3");

        Person person4 = new Person();
        person4.setId(4);
        person4.setPersonAge(4);
        person4.setPersonName("小4");

        personMap.put(1, person);
        personMap.put(2, person2);
        personMap.put(3, person3);
        personMap.put(4, person4);

    }

    @Cacheable("Person")
    public Person getPerson(int id) {
        System.out.println("cache not find,use source,id :" + id);

        return personMap.get(id);
    }

    @CachePut(value = "Person", key = "#id")
    @CacheEvict(cacheNames ="tancehuancun",allEntries = true)
    public Person updatePerson(int id, String name,int age) {
        System.out.println("update person,id " + id);
        Person person = personMap.get(id);
        person.setPersonAge(age);
        person.setPersonName(name);
        personMap.put(id, person);
        return person;
    }

    @Caching(
            evict = {
                    @CacheEvict("Person"),
                    @CacheEvict(cacheNames = "tancehuancun", allEntries = true)
            }
    )
    public void deletePerson(int id) {
        System.out.println("delect Person id: " + id);
        personMap.remove(id);
    }

    @CachePut(value = "Person", key = "#id")
    @CacheEvict(cacheNames = "tancehuancun", allEntries = true)
    public Person addPerson(int id, String name,int age){
        System.out.println("add person");
        Person person = new Person();
        person.setId(id);
        person.setPersonName(name);
        person.setPersonAge(age);

        personMap.put(id,person);
        return person;
    }
    
}
