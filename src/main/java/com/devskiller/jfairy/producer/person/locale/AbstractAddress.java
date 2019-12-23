package com.devskiller.jfairy.producer.person.locale;

import com.devskiller.jfairy.producer.person.Address;

/**
 * A base of all addresses. It carries all needed fields, but leaves most of formatting to subclasses.
 */
public abstract class AbstractAddress implements Address {
	protected final String street;
	protected final String streets;
	protected final String streetNumber;
	protected final String apartmentNumber;
	protected final String postalCode;
	protected final String city;

	public AbstractAddress(String street, String streets,String streetNumber, String apartmentNumber, String postalCode, String city) {
		this.street = street;
		this.streets = streets;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getStreets(){
		return streets;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public abstract String getAddressLine1();

	public abstract String getAddressLine2();

	@Override
	public String toString() {
		return getAddressLine1() + System.lineSeparator() + getAddressLine2();
	}
}
