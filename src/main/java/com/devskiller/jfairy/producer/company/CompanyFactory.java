package com.devskiller.jfairy.producer.company;

public interface CompanyFactory {

	CompanyProvider produceCompany(CompanyProperties.CompanyProperty... var1);

}
