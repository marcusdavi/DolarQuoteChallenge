package com.api.msdollartwodays.utils;

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

    public static LocalDate StringToLocalDate(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

}
