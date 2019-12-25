package com.devskiller.jfairy.producer.person;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.company.Company;

import static com.devskiller.jfairy.producer.person.Person.Sex.FEMALE;
import static com.devskiller.jfairy.producer.person.Person.Sex.MALE;

public class Person {

	public enum Sex {
		MALE(0,"男"), FEMALE(1,"女");

		private Integer value;
		private String name;

		Sex(Integer value, String name) {
			this.name = name;
			this.value= value;
		}

		public String getName(){
			return this.name;
		}

		public Integer getValue(){ return this.value; }
	}

	private final Address address;
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final String email;
	private final String username;
	private final String password;
	private final Sex sex;
	private final String telephoneNumber;
	private final String phone;
	private final LocalDate dateOfBirth;
	private final Integer age;
	private final Company company;
	private final String companyEmail;
	private final String nationalIdentityCardNumber;
	private final String passportNumber;
	private final Country nationality;

	public Person(String firstName, String middleName, String lastName, Address address, String email, String username,
	              String password, Sex sex, String telephoneNumber, String phone, LocalDate dateOfBirth, Integer age,
	              String nationalIdentityCardNumber,String passportNumber,
	              Company company, String companyEmail, Country nationality) {
		this.nationalIdentityCardNumber = nationalIdentityCardNumber;
		this.address = address;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.telephoneNumber = telephoneNumber;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.company = company;
		this.companyEmail = companyEmail;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
	}


	/**
	 * 获取名字
	 * */
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	/**
	 * 获取姓
	 * */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 获取个人邮箱
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * 获取用户名
	 * */
	public String getUsername() {
		return username;
	}

	/**
	 * 获取密码
	 * */
	public String getPassword() {
		return password;
	}

	/**
	 * 获取姓名
	 * */
	public String getFullName() {
		return lastName + firstName;
	}

	/**
	 * 性别是否为男
	 * */
	public boolean isMale() {
		return sex == MALE;
	}

	/**
	 * 性别是否为女
	 * */
	public boolean isFemale() {
		return sex == FEMALE;
	}

	/**
	 * 获取性别
	 * */
	public Sex getSex() {
		return sex;
	}

	/**
	 * 获取电话号码 格式为 0###-######## 或者 ########
	 * */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * 获取手机号
	 * */
	public String getPhone(){
		return phone;
	}

	/**
	 * 获取出生日期 年月日  2010-10-01
	 * */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * 获取年靓
	 * */
	public int getAge() {
		return age;
	}

	/**
	 * 获取身份证号
	 * */
	public String getNationalIdentityCardNumber() {
		return nationalIdentityCardNumber;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public Address getAddress() {
		return address;
	}

	public Company getCompany() {
		return company;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public Country getNationality() {
		return nationality;
	}
}
