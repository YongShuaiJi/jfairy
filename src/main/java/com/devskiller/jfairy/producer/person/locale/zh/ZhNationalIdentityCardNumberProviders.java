package com.devskiller.jfairy.producer.person.locale.zh;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.NationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.util.ZhFairyUtil;
import java.time.LocalDate;


public class ZhNationalIdentityCardNumberProviders implements NationalIdentityCardNumberProvider {

	private final Person.Sex sex;
	private final LocalDate date;
	private final BaseProducer baseProducers;
	private static final int ONE_MAX= 8;
	private static final int TWO_MAX= 99;

	public ZhNationalIdentityCardNumberProviders(Person.Sex sex, LocalDate date,BaseProducer baseProducers) {
		this.sex = sex;
		this.date = date;
		this.baseProducers = baseProducers;
	}

	@Override
	public String get() {
		StringBuilder idBuilder = new StringBuilder();
		idBuilder.append(baseProducers.randomElement(ZhFairyUtil.PROV_LIST));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, ZhFairyUtil.CITY_MAX, 2));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, ZhFairyUtil.DISTRICT_MAX, 2));
		idBuilder.append(ZhFairyUtil.getDateStr(date));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, TWO_MAX, 2));
		idBuilder.append(ZhFairyUtil.randomBetweenSequenceCode(sex,baseProducers, ONE_MAX, 1));
		idBuilder.append(ZhFairyUtil.getEndStr(idBuilder.toString()));
		return idBuilder.toString();
	}
}
