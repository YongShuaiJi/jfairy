/*
 * Copyright (c) 2013 Codearte
 */
package com.devskiller.jfairy;

import javax.inject.Inject;
import com.google.inject.Provider;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.company.CompanyFactory;
import com.devskiller.jfairy.producer.company.CompanyProperties;
import com.devskiller.jfairy.producer.net.NetworkProducer;
import com.devskiller.jfairy.producer.payment.CreditCard;
import com.devskiller.jfairy.producer.payment.CreditCardProvider;
import com.devskiller.jfairy.producer.payment.IBAN;
import com.devskiller.jfairy.producer.payment.IBANFactory;
import com.devskiller.jfairy.producer.payment.IBANProperties;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonFactory;
import com.devskiller.jfairy.producer.person.PersonProperties;
import com.devskiller.jfairy.producer.text.TextProducer;

public final class Fairy {

	private final TextProducer textProducer;
	private final PersonFactory personFactory;
	private final NetworkProducer networkProducer;
	private final BaseProducer baseProducer;
	private final DateProducer dateProducer;
	private final CreditCardProvider creditCardProvider;
	private final CompanyFactory companyFactory;
	private final IBANFactory ibanFactory;

	@Inject
	Fairy(TextProducer textProducer, PersonFactory personFactory, NetworkProducer networkProducer,
	      BaseProducer baseProducer, DateProducer dateProducer, CreditCardProvider creditCardProvider,
	      CompanyFactory companyFactory, IBANFactory ibanFactory) {
		this.textProducer = textProducer;
		this.personFactory = personFactory;
		this.networkProducer = networkProducer;
		this.baseProducer = baseProducer;
		this.dateProducer = dateProducer;
		this.creditCardProvider = creditCardProvider;
		this.companyFactory = companyFactory;
		this.ibanFactory = ibanFactory;
	}

	/**
	 *  无参初始化创建
	 *
	 *   @return A {@link com.devskiller.jfairy.Fairy} instance
	 * */

	public static Fairy create() {
		return Bootstrap.create();
	}

	public static Fairy create(Provider<DataMaster> dataMasterProvider) {
		return Bootstrap.create(dataMasterProvider);
	}


	public static Bootstrap.Builder builder() {
		return Bootstrap.builder();
	}

	/**
	 * Use this method for generating texts
	 *
	 * @return A {@link com.devskiller.jfairy.producer.text.TextProducer} instance
	 */
	public TextProducer textProducer() {
		return textProducer;
	}

	/**
	 * Use this method for fake persons
	 *
	 * @param personProperties desired person features
	 * @return A {@link com.devskiller.jfairy.producer.person.Person} instance
	 */
	public Person person(PersonProperties.PersonProperty... personProperties) {
		return personFactory.producePersonProvider(personProperties).get();
	}

	/**
	 * Use this method to generate fake company
	 * 允许传公司名称 其他公司信息根据公司名称生成
	 * @return A {@link com.devskiller.jfairy.producer.company.CompanyProvider} instance
	 */
	public Company company(CompanyProperties.CompanyProperty... CompanyInfo) {
		return companyFactory.produceCompany(CompanyInfo).get();
	}

	/**
	 * Use this method for get standard tools
	 *
	 * @return A {@link com.devskiller.jfairy.producer.BaseProducer} instance
	 */
	public BaseProducer baseProducer() {
		return baseProducer;
	}

	public DateProducer dateProducer() {
		return dateProducer;
	}

	/**
	 * Use this method for generating IBAN (International Bank Account Number)
	 *
	 * @return A {@link com.devskiller.jfairy.producer.payment.IBAN} instance
	 */
	public IBAN iban() {
		return ibanFactory.produceIBANProvider().get();
	}

	/**
	 * Use this method for generating IBAN (International Bank Account Number)
	 *
	 * @param properties desired IBAN features
	 * @return A {@link com.devskiller.jfairy.producer.payment.IBAN} instance
	 */
	public IBAN iban(IBANProperties.Property... properties) {
		return ibanFactory.produceIBANProvider(properties).get();
	}

	public CreditCard creditCard() {
		return creditCardProvider.get();
	}

	public NetworkProducer networkProducer() {
		return networkProducer;
	}
}
