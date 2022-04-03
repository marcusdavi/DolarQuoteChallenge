package com.api.msdollartwodays.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DateUtil {

    private static final String DATE_FORMAT = "MM-dd-yyyy";
    private static final String DATE_FORMAT_BR = "dd/MM/yyyy";
    private static final String DATE_FORMAT_API = "yyyy-MM-dd";

    public static void isDateValid(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static String formatDateBR(String strDateAPI) {
	String strOnlyDate = strDateAPI.split(" ")[0];

	DateTimeFormatter dateFormatBR = DateTimeFormatter.ofPattern(DATE_FORMAT_BR);

	return dateFormatBR.format(stringToLocalDateAPI(strOnlyDate));

    }

    public static LocalDate stringToLocalDate(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static LocalDate stringToLocalDateAPI(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_API);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static String localDateToString(LocalDate date) {

	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);

	return dateFormat.format(date);

    }

    public static String backToBusinessDayWithString(String strDate) {

	LocalDate localDate = stringToLocalDate(strDate).minusDays(1);

	if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
	    return DateUtil.localDateToString(localDate.minusDays(2));
	} else if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
	    return DateUtil.localDateToString(localDate.minusDays(1));
	}

	return DateUtil.localDateToString(localDate);

    }

    public static boolean isEqualOrAfterToday(String strDate) {

	LocalDate localDate = stringToLocalDate(strDate);
	LocalDate today = LocalDate.now();

	return (localDate.equals(today) || localDate.isAfter(today));

    }

    public static String minusDaysWithString(String strDate, int days) {

	LocalDate localDate = stringToLocalDate(strDate).minusDays(days);

	if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
	    return DateUtil.localDateToString(localDate.minusDays(2));
	} else if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
	    return DateUtil.localDateToString(localDate.minusDays(1));
	}

	return DateUtil.localDateToString(localDate);

    }

}
