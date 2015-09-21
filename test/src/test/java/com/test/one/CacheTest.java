package com.test.one;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.test.one.bean.Person;
import com.test.one.bean.School;
import com.test.one.resolver.Myreslover;
import com.test.one.service.JoinQueryService;
import com.test.one.service.PersonService;
import com.test.one.service.SchoolService;

import junit.framework.Assert;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CacheTest extends AbstractJUnit4SpringContextTests {
    
	@Autowired
    private PersonService personService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private JoinQueryService joinQueryService;

    @Test
    public void testBasicCRUD() {
    	System.out.println("1111");
        Person person = personService.getPerson(1);
        Myreslover myreslover = new Myreslover();
        System.out.println("2222");
        Person person1 = personService.getPerson(1);
        Assert.assertEquals(person, person1);
//
//        Person person2 = personService.updatePerson(1, "as", 1);
//        Person person3 = personService.getPerson(1);
//        Assert.assertEquals(person2, person3);
//
//        personService.deletePerson(1);
//        Person person4 = personService.getPerson(1);
//        Assert.assertNull(person4);
//
//
//        Person person5 = personService.addPerson(1, "xiao5", 5);
//        Person person6 = personService.getPerson(1);
//        Assert.assertEquals(person5, person6);
    }

    @Test
    public void testJoinQuery() {
        List list = joinQueryService.queryPersonAndSchool(1);
        Assert.assertTrue(list.size() == 2);

        personService.deletePerson(1);
        list = joinQueryService.queryPersonAndSchool(1);
        Assert.assertTrue(list.size() == 1);

        schoolService.deleteSchool(1);
        list = joinQueryService.queryPersonAndSchool(1);
        Assert.assertTrue(list.size() == 0);

        schoolService.addSchool(1,"小1");
        list = joinQueryService.queryPersonAndSchool(1);
        Assert.assertTrue(list.size() == 1);

        personService.addPerson(1,"小1",1);
        list = joinQueryService.queryPersonAndSchool(1);
        Assert.assertTrue(list.size() == 2);

        School school = schoolService.updateSchool(1, "小1");
        list = joinQueryService.queryPersonAndSchool(1);
        boolean isfind = false;
        for (Object o : list) {
            if (o instanceof School) {
                School school1 = (School) o;
                Assert.assertEquals(school,school1);
                isfind = true;
                break;
            }
        }
        if (!isfind)
            Assert.fail();
    }
    
}
