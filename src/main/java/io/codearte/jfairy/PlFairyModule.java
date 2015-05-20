package io.codearte.jfairy;

import io.codearte.jfairy.data.DataMaster;
import io.codearte.jfairy.dataProvider.VATIdentificationNumberProvider;
import io.codearte.jfairy.dataProvider.company.locale.pl.NIPProvider;
import io.codearte.jfairy.dataProvider.person.NationalIdentityCardNumberProvider;
import io.codearte.jfairy.dataProvider.person.PassportNumberProvider;
import io.codearte.jfairy.dataProvider.person.locale.pl.PlIdentityCardNumberProvider;
import io.codearte.jfairy.dataProvider.person.locale.pl.PlPassportNumberProvider;

import java.util.Random;

/**
 * @author Olga Maciaszek-Sharma
 * @since 21.02.15
 */
public class PlFairyModule extends FairyModule {

	public PlFairyModule(DataMaster dataMaster, Random random) {
		super(dataMaster, random);
	}

	@Override
	protected void configure() {
		super.configure();
		bind(NationalIdentityCardNumberProvider.class).to(PlIdentityCardNumberProvider.class);
		bind(VATIdentificationNumberProvider.class).to(NIPProvider.class);
		bind(PassportNumberProvider.class).to(PlPassportNumberProvider.class);
	}
}
