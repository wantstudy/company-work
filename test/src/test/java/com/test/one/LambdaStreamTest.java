package com.test.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.test.one.bean.Adult;
import com.test.one.bean.Person;

@RunWith(JUnit4.class)
public class LambdaStreamTest {

	/**
	 * java集合内部迭代
	 */
	@Test
	public void testBlukOperation(){
		List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		persons.forEach(p->p.setPersonAge(11));
		persons.forEach(p -> System.out.println(p.toString()));
	}
	
	/**
	 * Stream predicate Filter
	 */
	@Test
	public void testStreamFilter(){
		List<Person> persons = Arrays.asList(new Person(1,11), new Person(2,12), new Person(3,13));
		Stream<Adult> map = persons.stream()
									   .filter(p -> p.getPersonAge() > 11)
									   .map(new Function<Person, Adult>() {
											@Override
											public Adult apply(Person t) {
												return new Adult(t);
											}
									});
		
		Stream<Adult> map2 = persons.stream().filter(p -> p.getId() > 2)
						.map(person -> new Adult(person));
		
		List<Adult> collect = map.collect(Collectors.toList());
		collect.forEach( a -> System.out.println("map" + a.toString()));
		
		ArrayList<Adult> collect2 = map2.collect(Collectors.toCollection(ArrayList::new));
		collect2.forEach(a -> System.out.println(a.getId()));
		
//		long count = filter.count();
//		System.out.println(count);
	}
	
	/**
	 * Parallel
	 */
	@Test
	public void testStreamParallel(){
		long t0 = System.nanoTime();
		int[] array = IntStream.range(0, 1_000_000).filter(p -> p%2 == 0).toArray();
		long t1 =  System.nanoTime();
		int[] array2 = IntStream.range(0, 1_000_000).parallel().filter(p-> p%2 == 0).toArray();
		long t2 = System.nanoTime();
		System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
		
	}
}
