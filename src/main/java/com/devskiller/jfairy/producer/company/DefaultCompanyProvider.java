package com.devskiller.jfairy.producer.company;

import javax.inject.Inject;

import com.devskiller.jfairy.producer.person.Person;
import com.google.inject.assistedinject.Assisted;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.VATIdentificationNumberProvider;
import com.devskiller.jfairy.producer.util.TextUtils;

public class DefaultCompanyProvider implements CompanyProvider {

	protected String names;
	protected String name;
	protected String domain;
	protected String email;
	protected String vatIdentificationNumber;

	protected BaseProducer baseProducer;
	protected DataMaster dataMaster;


	protected VATIdentificationNumberProvider vatIdentificationNumberProvider;

	@Inject
	public DefaultCompanyProvider(@Assisted String names,BaseProducer baseProducer,
								  DataMaster dataMaster,
								  VATIdentificationNumberProvider vatIdentificationNumberProvider,
								  @Assisted CompanyProperties.CompanyProperty... companyProperties) {
		this.names = names;
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.vatIdentificationNumberProvider = vatIdentificationNumberProvider;

		for (CompanyProperties.CompanyProperty companyProperty : companyProperties) {
			companyProperty.apply(this);
		}
	}

	@Override
	public Company get() {

		generateName();
		generateDomain();
		generateEmail();
		generateVatIdentificationNumber();

		return new Company(names,name, domain, email, vatIdentificationNumber);
	}

	@Override
	public void generateName() {
		if (name != null) {
			return;
		}
		name = dataMaster.getRandomValue(COMPANY_NAME);
	}

	@Override
	public void generateDomain() {
		if (domain != null) {
			return;
		}

		String host = TextUtils.stripAccents(StringUtils.strip(StringUtils.deleteWhitespace(baseProducer.getFullSpell(name)), ".").replace("/", ""));
		domain = host + "." + dataMaster.getRandomValue(DOMAIN);
	}

	@Override
	public void generateEmail() {
		if (email != null) {
			return;
		}
		email = baseProducer.getFullSpell(names);
	}

	@Override
	public void generateVatIdentificationNumber() {
		if (vatIdentificationNumber != null) {
			return;
		}
		vatIdentificationNumber = vatIdentificationNumberProvider.get();
	}

	@Override
	public void setNames(String names){
		this.names = names;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setVatIdentificationNumber(String vatIdentificationNumber) {
		this.vatIdentificationNumber = vatIdentificationNumber;
	}
}
