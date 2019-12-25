package com;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.junit.Test;

public class test {

	@Test
	public void test() {

		for (int i = 0 ;i < 1;i++){
			Fairy fairy  =  Fairy.create();
			Person person  =  fairy.person();
			System.out.println(person.getNationalIdentityCardNumber());

		}


	}

}
