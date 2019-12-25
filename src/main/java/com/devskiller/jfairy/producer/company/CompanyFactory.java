package com.devskiller.jfairy.producer.company;

public interface CompanyFactory {

	CompanyProvider produceCompany(String corporateName, CompanyProperties.CompanyProperty... companyPropertiesz);

}
