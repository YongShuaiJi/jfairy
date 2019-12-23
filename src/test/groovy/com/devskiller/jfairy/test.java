package com.devskiller.jfairy;

import com.devskiller.jfairy.producer.person.Person;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.util.Locale;

public class test {

	@Test
	public void test(){
		Fairy fairy  =  Fairy.create();
		Person person  =  fairy.person();
//		System.out.println(person.getAddress().getAddressLine1().replace(" ","").replace(person.getAddress().getCity(),"").replace("市","").trim());
//		System.out.println(person.getEmail().replace(" ",""));
//		System.out.println(person.getFirstName());
//		System.out.println(person.getLastName());
//		System.out.println(person.getCompany().getDomain());

//		System.out.println(person.getCompany().getEmail());
//		System.out.println(person.getLastName());
//		System.out.println(person.getFirstName());
//		System.out.println(person.getCompany().getDomain());
//		System.out.println(getFullSpell("的数据爱疯"));
//		System.out.println(person.getCompany().getEmail().replace(" ",""));
//		System.out.println(person.getCompany().getEmail().replace(" ",""));

		System.out.println(person.getAddress().getAddressLine1());
		System.out.println(person.getAddress().getAddressLine2());
	}


}
