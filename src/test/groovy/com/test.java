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
		Company company = fairy.company(CompanyProperties.CompanyProperty.withName("山东镭数信息科技有限公司"));
		System.out.println(company.getName());
		System.out.println(company.getVatIdentificationNumber());
		System.out.println(company.getUrl());
		System.out.println(company.getDomain());
		System.out.println(company.getEmail());
		System.out.println(person.getFullName());
		System.out.println(person.getCompany().getName());

	}

}
