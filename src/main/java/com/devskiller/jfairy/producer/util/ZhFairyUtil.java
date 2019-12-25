package com.devskiller.jfairy.producer.util;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.Person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Hashtable;

/**
 * com.devskiller.jfairy.producer.util.ZhFairyUtil
 * 1、身份证号生成只能精确的省级：市和区没有准确校验
 * 2、生成的身份账号与随机所选择的城市没有关系
 * @author lhfcws
 * @author jiyonghsuai
 * @since 2017/3/10
 */
public class ZhFairyUtil {

	private ZhFairyUtil() {}

	private static final String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
	private static final String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };

	/**
	 * Codes of China provinces
	 */
	public static final String[] PROV_LIST = {
		"11",	//北京
		"12",	//天津
		"13",	//河北
		"14",	//山西
		"15",	//内蒙古
		"21",	//辽宁
		"22",	//吉林
		"23",	//黑龙江
		"31",	//上海
		"32",	//江苏
		"33",	//浙江
		"34",	//安徽
		"35",	//福建
		"36",	//江西
		"37",	//山东
		"41",	//河南"
		"42",	//湖北
		"43",	//湖南
		"44",	//广东
		"45",	//广西
		"46",	//海南
		"50",	//重庆
		"51",	//四川
		"52",	//贵州
		"53",	//云南
		"54",	//西藏
		"61",	//陕西
		"62",	//甘肃
		"63",	//青海
		"64",	//宁夏
		"65",	//新疆
	};


	/**
	 * Max code of city
	 */
	public static final int CITY_MAX = 30;
	/**
	 * Max code of city district
	 */
	public static final int DISTRICT_MAX = 12;

	/**
	 * Get random number from 1 to max in 0 leading string format.
	 * @param baseProducer BaseProducer
	 * @param max         upper bound of number
	 * @param paddingSize padding size
	 * @return A number smaller than #max with #paddingSize digits in string format
	 */

	public static String getRandomNumStr(BaseProducer baseProducer, int max, int paddingSize) {
		int rndNum = baseProducer.randomBetween(1, max);
		String numStr = "" + rndNum;
		while (numStr.length() < paddingSize) {
			numStr = "0" + numStr;
		}
		return numStr;
	}


	public static String getDateStr(LocalDate date){
		return new SimpleDateFormat("yyyyMMdd").format(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
	}

	/**
	 * 17位 顺序码：奇数表示男性 偶数表示女性
	 * */
	public static String randomBetweenSequenceCode(Person.Sex sex,BaseProducer baseProducer, int max, int paddingSize){
		int rndNum = 0;
		if (sex == Person.Sex.FEMALE){
			rndNum = baseProducer.randomBetweenEven(1, max);
		}else {
			rndNum = baseProducer.randomBetweenOdd(1, max);
		}
		String numStr = "" + rndNum;
		return numStr;
	}

	public static String getEndStr(String Ai){
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String endCode = ValCodeArr[modValue];
		return endCode;
	}

	@SuppressWarnings("unchecked")
	private static Hashtable getAreaCode() {
		Hashtable hashtable = new Hashtable();
		hashtable.put("11", "北京");
		hashtable.put("12", "天津");
		hashtable.put("13", "河北");
		hashtable.put("14", "山西");
		hashtable.put("15", "内蒙古");
		hashtable.put("21", "辽宁");
		hashtable.put("22", "吉林");
		hashtable.put("23", "黑龙江");
		hashtable.put("31", "上海");
		hashtable.put("32", "江苏");
		hashtable.put("33", "浙江");
		hashtable.put("34", "安徽");
		hashtable.put("35", "福建");
		hashtable.put("36", "江西");
		hashtable.put("37", "山东");
		hashtable.put("41", "河南");
		hashtable.put("42", "湖北");
		hashtable.put("43", "湖南");
		hashtable.put("44", "广东");
		hashtable.put("45", "广西");
		hashtable.put("46", "海南");
		hashtable.put("50", "重庆");
		hashtable.put("51", "四川");
		hashtable.put("52", "贵州");
		hashtable.put("53", "云南");
		hashtable.put("54", "西藏");
		hashtable.put("61", "陕西");
		hashtable.put("62", "甘肃");
		hashtable.put("63", "青海");
		hashtable.put("64", "宁夏");
		hashtable.put("65", "新疆");
		return hashtable;
	}


}
