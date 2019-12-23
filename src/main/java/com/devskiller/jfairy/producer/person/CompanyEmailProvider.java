package com.devskiller.jfairy.producer.person;

import com.devskiller.jfairy.producer.BaseProducer;
import com.google.inject.Provider;

import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.util.TextUtils;

import static org.apache.commons.lang3.StringUtils.lowerCase;

public class CompanyEmailProvider implements Provider<String> {

	private final String firstName;
	private final String lastName;
	private final Company company;
	private final BaseProducer baseProducers;

	public CompanyEmailProvider(String firstName, String lastName, Company company,BaseProducer baseProducers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.baseProducers = baseProducers;
	}

	@Override
	public String get() {
		String pix_em = baseProducers.getFullSpell(firstName + lastName);
		String email = lowerCase(pix_em + '@' + company.getDomain()).replaceAll(" ", ".");
		return TextUtils.stripSharpS(TextUtils.stripAccents(email));
	}
}
