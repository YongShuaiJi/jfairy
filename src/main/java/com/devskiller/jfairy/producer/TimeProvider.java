/*
 * Copyright (c) 2013. Codearte
 */

package com.devskiller.jfairy.producer;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Singleton
public class TimeProvider {

	public int getCurrentYear() {
		return getCurrentTime().getYear();
	}

	public LocalDateTime getCurrentTime() {
		return LocalDateTime.now();
	}

	public LocalDate getCurrentDate() {
		return LocalDate.now();
	}
}
