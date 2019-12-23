package com.devskiller.jfairy.producer.person;

import com.google.inject.Provider;
import org.apache.commons.lang3.StringUtils;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.util.TextUtils;

import static com.devskiller.jfairy.producer.person.PersonProvider.PERSONAL_EMAIL;
import static org.apache.commons.lang3.StringUtils.lowerCase;

public class EmailProvider implements Provider<String> {

	private final DataMaster dataMaster;
	private final BaseProducer baseProducer;
	private final String firstName;
	private final String lastName;

	public EmailProvider(DataMaster dataMaster, BaseProducer baseProducer,
						 String firstName, String lastName) {
		this.dataMaster = dataMaster;
		this.baseProducer = baseProducer;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String get() {
		String prefix = StringUtils.replace(lastName + firstName, " ", "");
		String prefix_em = baseProducer.getFullSpell(prefix);
		String email = lowerCase(prefix_em + '@' + dataMaster.getRandomValue(PERSONAL_EMAIL));
		return TextUtils.stripSharpS(TextUtils.stripAccents(email));
	}
}
