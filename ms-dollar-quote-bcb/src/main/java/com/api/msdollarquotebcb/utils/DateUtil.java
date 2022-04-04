package com.api.msdollarquotebcb.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DateUtil {

    private static final String DATE_FORMAT = "MM-dd-yyyy";

    public static void isDateValid(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static LocalDate stringToLocalDate(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static String localDateToString(LocalDate date) {

	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);

	return dateFormat.format(date);

    }

    public static boolean isEqualOrAfterToday(String strDate) {

	LocalDate localDate = stringToLocalDate(strDate);
	LocalDate today = LocalDate.now();

	return (localDate.equals(today) || localDate.isAfter(today));

    }
}
