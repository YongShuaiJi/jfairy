package com.devskiller.jfairy.producer.person;

import java.time.LocalDate;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provider;

import com.devskiller.jfairy.producer.company.Company;

public interface PersonProvider extends Provider<Person> {

	int MIN_AGE = 10;
	int MAX_AGE = 60;
	@VisibleForTesting
	String FIRST_NAME = "firstNames";
	@VisibleForTesting
	String LAST_NAME = "lastNames";
	@VisibleForTesting
	String PERSONAL_EMAIL = "personalEmails";
	@VisibleForTesting
	String TELEPHONE_NUMBER_FORMATS = "telephone_number_formats";
	@VisibleForTesting
	String phone_prefix = "phone_number_prefix";

	@Override
	Person get();

	void generateSex();

	void generateCompany();

	void generateFirstName();

	void generateMiddleName();

	void generateLastName();

	void generateEmail();

	void generateUsername();

	void generateTelephoneNumber();

	void generatePhone();

	void generateAge();

	void generateDateOfBirth();

	void generateCompanyEmail();

	void generatePassword();

	void generateNationalIdentityCardNumber();

	void generateAddress();

	void generatePassportNumber();

	void setTelephoneNumberFormat(String telephoneFormat);

	void setSex(Person.Sex sex);

	void setAge(int age);

	void setCompany(Company company);

	void setFirstName(String firstName);

	void setMiddleName(String middleName);

	void setLastName(String lastName);

	void setEmail(String email);

	void setUsername(String username);

	void setTelephoneNumber(String telephoneNumber);

	void setDateOfBirth(LocalDate dateOfBirth);

	void setPassword(String password);

	void setAddress(Address address);

	void setCompanyEmail(String companyEmail);

	void setNationalIdentityCardNumber(String nationalIdentityCardNumber);

	void setPassportNumber(String passportNumber);
}


