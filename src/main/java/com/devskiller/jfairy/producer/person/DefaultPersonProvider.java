package com.devskiller.jfairy.producer.person;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.devskiller.jfairy.producer.company.CompanyProvider;
import com.devskiller.jfairy.producer.person.locale.zh.ZhNationalIdentityCardNumberProviders;
import com.google.inject.assistedinject.Assisted;
import org.apache.commons.lang3.RandomStringUtils;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.TimeProvider;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.company.CompanyFactory;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.stripAccents;

public class DefaultPersonProvider implements PersonProvider {

	protected Person.Sex sex;
	protected String telephoneNumberFormat;
	protected Integer age;
	protected LocalDate dateOfBirth;
	protected Company company;
	protected Address address;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected String username;
	protected String telephoneNumber;
	protected String phone;
	protected String password;
	protected String companyEmail;
	protected String nationalIdentityCardNumber;
	protected String passportNumber;
	protected Country nationality;

	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final BaseProducer baseProducer;
	protected final NationalIdentityCardNumberProvider nationalIdentityCardNumberProvider;
	protected final AddressProvider addressProvider;
	protected final CompanyFactory companyFactory;
	protected final TimeProvider timeProvider;
	protected final PassportNumberProvider passportNumberProvider;

	@Inject
	public DefaultPersonProvider(DataMaster dataMaster,
	                             DateProducer dateProducer,
	                             BaseProducer baseProducer,
	                             NationalIdentityCardNumberProvider nationalIdentityCardNumberProvider,
	                             AddressProvider addressProvider,
	                             CompanyFactory companyFactory,
	                             PassportNumberProvider passportNumberProvider,
	                             TimeProvider timeProvider,
	                             @Assisted PersonProperties.PersonProperty... personProperties) {

		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.baseProducer = baseProducer;
		this.nationalIdentityCardNumberProvider = nationalIdentityCardNumberProvider;
		this.addressProvider = addressProvider;
		this.passportNumberProvider = passportNumberProvider;
		this.companyFactory = companyFactory;
		this.timeProvider = timeProvider;

		for (PersonProperties.PersonProperty personProperty : personProperties) {
			personProperty.apply(this, baseProducer);
		}
	}

	@Override
	public Person get() {

		generateSex();
		generateFirstName();
		generateMiddleName();
		generateLastName();
		generateCompany();
		generateEmail();
		generateUsername();
		generateTelephoneNumber();
		generatePhone();
		generateAge();
		generateDateOfBirth();
		generateCompanyEmail();
		generatePassword();
		generateNationalIdentityCardNumber();
		generatePassportNumber();
		generateAddress();
		generateNationality();

		return new Person(firstName, middleName, lastName, address, email,
			username, password, sex, telephoneNumber, phone, dateOfBirth, age,
			nationalIdentityCardNumber, passportNumber,
			company, companyEmail, nationality);
	}

	@Override
	public void generateSex() {
		if (sex != null) {
			return;
		}
		sex = baseProducer.trueOrFalse() ? Person.Sex.MALE : Person.Sex.FEMALE;
	}

	@Override
	public void generateCompany() {
		if (company != null) {
			return;
		}
		company = companyFactory.produceCompany().get();
	}

	@Override
	public void generateFirstName() {
		if (firstName != null) {
			return;
		}
		firstName = dataMaster.getValuesOfType(FIRST_NAME, sex.getName(), String.class);
	}

	@Override
	public void generateMiddleName() {
		if (middleName != null) {
			return;
		}
		middleName = baseProducer.trueOrFalse() ? dataMaster.getValuesOfType(FIRST_NAME, sex.getName(), String.class) : "";
	}

	@Override
	public void generateLastName() {
		if (lastName != null) {
			return;
		}
		lastName = dataMaster.getValuesOfType(LAST_NAME, sex.getName(), String.class);
	}

	@Override
	public void generateEmail() {
		if (email != null) {
			return;
		}
		EmailProvider emailProvider = new EmailProvider(dataMaster, baseProducer, firstName, lastName);
		email = emailProvider.get();
	}

	@Override
	public void generateUsername() {
		if (username != null) {
			return;
		}
		if (baseProducer.trueOrFalse()) {
			username = lowerCase(stripAccents(firstName.substring(0, 1) + lastName));
		} else {
			username = lowerCase(stripAccents(lastName.substring(0, 1) + firstName));
		}
	}

	@Override
	public void generateTelephoneNumber() {
		if (telephoneNumber != null) {
			return;
		}
		if (telephoneNumberFormat == null) {
			telephoneNumberFormat = dataMaster.getRandomValue(TELEPHONE_NUMBER_FORMATS);
		}
		telephoneNumber = baseProducer.numerify(telephoneNumberFormat);
	}

	@Override
	public void generatePhone() {
		if (phone != null) {
			return;
		}
		String phone_pre = dataMaster.getRandomValue(String.valueOf(phone_prefix));
		phone = baseProducer.fullPhone(phone_pre);
	}

	@Override
	public void generateAge() {
		if (dateOfBirth != null) {
			age = (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDateTime.now());
		} else {
			if (age != null) {
				return;
			}
			age = baseProducer.randomBetween(MIN_AGE, MAX_AGE);
		}
	}

	@Override
	public void generateDateOfBirth() {
		if (dateOfBirth != null) {
			return;
		}
		LocalDate maxDate = timeProvider.getCurrentDate().minusYears(age);
		LocalDate minDate = maxDate.minusYears(1).plusDays(1);
		dateOfBirth = dateProducer.randomDateBetweenTwoDates(minDate, maxDate);
	}

	@Override
	public void generateCompanyEmail() {
		if (companyEmail != null) {
			return;
		}
		CompanyEmailProvider companyEmailProvider = new CompanyEmailProvider(firstName, lastName, company,baseProducer);
		companyEmail = companyEmailProvider.get();
	}

	@Override
	public void generatePassword() {
		if (password != null) {
			return;
		}
		// FIXME: Replace this with baseProducer
		password = RandomStringUtils.randomAlphanumeric(8);
	}

	@Override
	public void generateNationalIdentityCardNumber() {
		if (nationalIdentityCardNumber != null) {
			return;
		}
		ZhNationalIdentityCardNumberProviders zhNationalIdentityCardNumberProviders = new ZhNationalIdentityCardNumberProviders(this.sex,dateOfBirth,baseProducer);
		nationalIdentityCardNumber = zhNationalIdentityCardNumberProviders.get();
	}

	@Override
	public void generateAddress() {
		if (address != null) {
			return;
		}
		address = addressProvider.get();
	}

	@Override
	public void generatePassportNumber() {
		if (passportNumber != null) {
			return;
		}
		passportNumber = passportNumberProvider.get();
	}

	private void generateNationality() {
		List<Country> countries = Country.findCountryForLanguage(dataMaster.getLanguage());
		nationality = !countries.isEmpty() ? baseProducer.randomElement(countries) : Country.China;
	}

	@Override
	public void setTelephoneNumberFormat(String telephoneFormat) {
		telephoneNumberFormat = telephoneFormat;
	}

	@Override
	public void setSex(Person.Sex sex) {
		this.sex = sex;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	@Override
	public void setNationalIdentityCardNumber(String nationalIdentityCardNumber) {
		this.nationalIdentityCardNumber = nationalIdentityCardNumber;
	}

	@Override
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
}


