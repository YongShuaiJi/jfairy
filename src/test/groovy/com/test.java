package com;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

public class test {

	@Test
	public void test() {

		Fairy fairy  =  Fairy.create();
		Person person  =  fairy.person();
		System.out.println(person.getCompany().getName());
		System.out.println(person.getFullName());

	}
}
