package com.devskiller.jfairy.producer.person.locale.zh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.person.Person;
import com.google.inject.Inject;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.TimeProvider;
import com.devskiller.jfairy.producer.person.NationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.util.ZhFairyUtil;

/**
 * Chinese National Identity Card Number, total 18 digits
 *
 * @author Lhfcws
 * @since 27.02.17
 * @author jiyongshuai
 * 此类拿出的身份证编号不对已经舍弃
 */
@Deprecated
public class ZhNationalIdentityCardNumberProvider implements NationalIdentityCardNumberProvider {

	/**
	 * The last 4 digit is an order number from 0001 to 9999
	 */
	private static final int TWO_MAX = 99;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	private final BaseProducer baseProducer;
	private final DateProducer dateProducer;
	protected final DataMaster dataMaster;

	@Inject
	public ZhNationalIdentityCardNumberProvider(DataMaster dataMaster,BaseProducer baseProducer) {
		this.baseProducer = baseProducer;
		this.dateProducer = new DateProducer(baseProducer, new TimeProvider());
		this.dataMaster = dataMaster;
	}

	@Override
	public String get() {
		StringBuilder idBuilder = new StringBuilder();
		idBuilder.append(baseProducer.randomElement(ZhFairyUtil.PROV_LIST));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducer, ZhFairyUtil.CITY_MAX, 2));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducer, ZhFairyUtil.DISTRICT_MAX, 2));
		idBuilder.append(getBirthDate());
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducer, TWO_MAX, 2));
		idBuilder.append(ZhFairyUtil.randomBetweenSequenceCode(baseProducer.trueOrFalse() ? Person.Sex.MALE : Person.Sex.FEMALE,baseProducer, TWO_MAX, 3));
		idBuilder.append(ZhFairyUtil.getEndStr(idBuilder.toString()));
		return idBuilder.toString();
	}

	private String getBirthDate() {
		LocalDateTime birthDate = this.dateProducer.randomDateInThePast(50);
		return formatter.format(birthDate);
	}
}

