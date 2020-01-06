package com;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.RandomGenerator;
import com.devskiller.jfairy.producer.net.NetworkProducer;
import com.devskiller.jfairy.producer.person.Person;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test {

	@Test
	public void test() {
//		for (int i = 0 ;i < 100;i++){
//			Fairy fairy  =  Fairy.create();
//			Person person  =  fairy.person();
//			System.out.println(person.getAge());
//			System.out.println(person.getNationalIdentityCardNumber());
//		}
//		List<String> strList = new ArrayList<>();
//		strList.add("111");
//		randomElements(strList,0);


		NetworkProducer nt = Fairy.create().networkProducer();
		System.out.println(nt.url(true));
		System.out.println(nt.ipAddress());

	}

	public <T> List<T> randomElements(List<T> elements, int count) {
		if (elements.size() >= count) {
			return extractRandomList(elements, count);
		} else {
			List<T> randomElements = new ArrayList<T>();
			randomElements.addAll(extractRandomList(elements, count % elements.size()));
			do {
				randomElements.addAll(extractRandomList(elements, elements.size()));
			} while (randomElements.size() < count);
			return randomElements;
		}
	}

	private <T> List<T> extractRandomList(List<T> elements, int count) {
		shuffle(elements);
		return elements.subList(0, count);
	}

	public <T> List<T> shuffle(List<T> elements) {

		Collections.shuffle(elements, new Random());
		return elements;
	}

}
