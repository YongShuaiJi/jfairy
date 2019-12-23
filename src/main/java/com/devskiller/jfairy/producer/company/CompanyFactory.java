package com.devskiller.jfairy.producer.company;

public interface CompanyFactory {

	CompanyProvider produceCompany(String names, CompanyProperties.CompanyProperty... companyPropertiesz);

}
