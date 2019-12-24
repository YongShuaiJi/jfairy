# jFairy by Devskiller

[![Build Status](https://travis-ci.org/Devskiller/jfairy.svg?branch=master)](https://travis-ci.org/Devskiller/jfairy) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.devskiller/jfairy/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.devskiller/jfairy) [![Javadocs](http://www.javadoc.io/badge/com.devskiller/jfairy.svg)](http://www.javadoc.io/doc/com.devskiller/jfairy) [![Coverage Status](https://img.shields.io/coveralls/Devskiller/jfairy.svg)](https://coveralls.io/r/Codearte/jfairy)
[![Stack Overflow](https://img.shields.io/badge/stack%20overflow-jfairy-4183C4.svg)](https://stackoverflow.com/questions/tagged/jfairy)
[![Join the chat at https://gitter.im/Codearte/jfairy](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Codearte/jfairy?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Java fake data generator. Based on Wikipedia:

> Fairyland, in folklore, is the fabulous land or abode of fairies or fays.
> 分支做了一些针对中文的优化，舍弃了除中文外的其他国家数据构建
## Try jFairy online!

https://devskiller.com/datafairy/

## Usage

Creating simple objects:

```java
Fairy fairy = Fairy.create();
Person person = fairy.person();
System.out.println(person.getFirstName());            
// 永帅   拿到名字
System.out.println(person.getEmail());               
// barker@yahoo.com 人名全拼+@+域名
System.out.println(person.getTelephoneNumber());     
// 0531-83991929  形式如下: 0###-########或者########

Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(21));
System.out.println(adultMale.isMale());           
// true
```

Creating related objects:

```java
Fairy fairy = Fairy.create();
Company company = fairy.company();
System.out.println(company.getName());          
// 山东镭数科技有限公司
System.out.println(company.getUrl());           
// http://www.robuteniaassociates.com

Person salesman = fairy.person(PersonProperties.withCompany(company));
System.out.println(salesman.getFullName());     
// 纪永帅
System.out.println(salesman.getCompanyEmail()); 
// jiyongshuai@robuteniaassociates.com  人名全拼@公司前缀全拼+域名
```

Locale support:

```java
Fairy enFairy = Fairy.create();                               
默认中文内容，不支持其他构建其他国家的数据
```

## Other samples

Look into [code samples](https://github.com/Devskiller/jfairy/tree/master/src/test/groovy/snippets/)

## Building

This project can be built using maven command:

    ./mvnw install

