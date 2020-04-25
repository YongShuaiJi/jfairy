package com;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.company.CompanyProperties;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonProperties;
import org.junit.Test;

public class test {

	@Test
	public void test() {
		Fairy fairy  =  Fairy.create();
		Person person  =  fairy.person(PersonProperties.withLastName("王"));
//			System.out.println(fairy.company(""));
//			System.out.println(person.getAge());
//			System.out.println(fairy.company("山东鲁能足球").getVatIdentificationNumber());
		Company company = fairy.company();
		System.out.println(company.getName());
		System.out.println(company.getVatIdentificationNumber());
		System.out.println(company.getUrl());
		System.out.println(company.getDomain());
		System.out.println(company.getEmail());
		System.out.println(person.getFullName());
		System.out.println(person.getCompany().getName());
//		System.out.println(person.getCompany().getCorporateName());
//		System.out.println(person.getNationalIdentityCardNumber());

	}

}
