package com.test.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SuperTest {
	
	private Runnable runnable;

	@Test
	public void testSuperQ(){
//		String[] array = {"a", "b", "c"};
//		for(Integer i : Lists.newArrayList(1,2,3)){
////		  Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
//		}
//
		List<String> names = new ArrayList<>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		List<Character> collect = names.stream().map(name -> name.charAt(0)).collect(Collectors.toList());
		collect.forEach(System.out::println);

	}
}
