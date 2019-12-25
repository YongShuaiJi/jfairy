package com.devskiller.jfairy.producer.person.locale;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * An address format typical for European countries but the UK and ex-Soviet union.
 */
public abstract class ContinentalAddress extends AbstractAddress {
	public ContinentalAddress(String street, String streets,String streetNumber, String apartmentNumber, String postalCode, String city) {
		super(street,streets, streetNumber, apartmentNumber, postalCode, city);
	}

	protected abstract String getApartmentMark();

	protected String getStreetNumberSeparator() {
		return " ";
	}

	@Override
	public String getAddress() {
		return street + getStreetNumberSeparator() + streetNumber
				+ (isNotBlank(apartmentNumber) ? getApartmentMark() + apartmentNumber : "");
	}

	@Override
	public String getPostDetails() {
		return postalCode + " " + city;
	}
}
