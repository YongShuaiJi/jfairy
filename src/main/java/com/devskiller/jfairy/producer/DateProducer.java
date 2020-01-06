/*
 * Copyright (c) 2013. Codearte
 */

package com.devskiller.jfairy.producer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneOffset;

import com.google.common.annotations.VisibleForTesting;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

@Singleton
public class DateProducer {

	@VisibleForTesting
	static final int SECONDS_BEFORE_TO_BE_IN_THE_PAST = 1;

	private final BaseProducer baseProducer;
	private final TimeProvider timeProvider;

	@Inject
	public DateProducer(BaseProducer baseProducer, TimeProvider timeProvider) {
		this.baseProducer = baseProducer;
		this.timeProvider = timeProvider;
	}

	public LocalDateTime randomDateInThePast(int maxYearsEarlier) {
		checkArgument(maxYearsEarlier >= 0, "%s has to be >= 0", maxYearsEarlier);
		LocalDateTime currentDate = timeProvider.getCurrentTime();
		LocalDateTime latestDateInThePast = currentDate.minusSeconds(SECONDS_BEFORE_TO_BE_IN_THE_PAST);
		LocalDateTime maxYearsEarlierDate = currentDate.minusYears(maxYearsEarlier);
		return randomDateBetweenTwoDates(maxYearsEarlierDate, latestDateInThePast);
	}

	public LocalDateTime randomDateBetweenYearAndNow(int fromYear) {
		int actualYear = timeProvider.getCurrentYear();
		return randomDateInThePast(actualYear - fromYear);
	}

	public LocalDate randomDateBetweenTwoDates(LocalDate from, LocalDate to) {
		return randomDateBetweenTwoDates(from.atStartOfDay(), to.atStartOfDay()).toLocalDate();
	}

	public LocalDateTime randomDateBetweenTwoDates(LocalDateTime from, LocalDateTime to) {
		long between = baseProducer.randomBetween(from.toInstant(ZoneOffset.UTC).toEpochMilli(),
			to.toInstant(ZoneOffset.UTC).toEpochMilli());
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(between), ZoneOffset.UTC);
	}

	public LocalDateTime randomDateBetweenYears(int fromYear, int toYear) {
		checkArgument(fromYear <= toYear, "%s has to be <= %s", fromYear, toYear);
		LocalDateTime fromDate = getDateForFirstDayForGivenYear(fromYear);
		LocalDateTime toDate = getDateForLastDayForGivenYear(toYear);
		return randomDateBetweenTwoDates(fromDate, toDate);
	}

	private LocalDateTime getDateForLastDayForGivenYear(int year) {
		return LocalDateTime.of(year, Month.JANUARY, 1, 23, 59).with(lastDayOfYear());
	}

	private LocalDateTime getDateForFirstDayForGivenYear(int year) {
		return LocalDateTime.of(year, Month.JANUARY, 1, 0, 0).with(firstDayOfYear());
	}

	public LocalDateTime randomDateBetweenNowAndFuturePeriod(Period futurePeriod) {
		LocalDateTime now = timeProvider.getCurrentTime();
		return randomDateBetweenTwoDates(now, now.plus(futurePeriod));
	}

	public LocalDateTime randomDateInTheFuture(int years) {
		return randomDateBetweenNowAndFuturePeriod(Period.ofYears(years));
	}

	public LocalDateTime randomDateInTheFuture() {
		return randomDateInTheFuture(100);
	}
}
