package com.api.msdollartwodays.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DateUtil {

    private static final String DATE_FORMAT_PARAM_API = "MM-dd-yyyy";
    private static final String DATE_FORMAT_BR = "dd/MM/yyyy";
    private static final String DATE_FORMAT_API = "yyyy-MM-dd";

    public static void isDateValid(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_BR);

	LocalDate.parse(strDate, dateTimeFormatter);

    }

    public static String formatDateBR(String strDateAPI) {
	String strOnlyDate = strDateAPI.split(" ")[0];

	DateTimeFormatter dateFormatBR = DateTimeFormatter.ofPattern(DATE_FORMAT_BR);

	return dateFormatBR.format(stringToLocalDateReturnAPI(strOnlyDate));

    }

    public static String formatDateToParamAPI(String strDateUser) {
	DateTimeFormatter dateFormatParamAPI = DateTimeFormatter.ofPattern(DATE_FORMAT_PARAM_API);
	LocalDate dateUser = stringToLocalDate(strDateUser);

	return dateFormatParamAPI.format(dateUser);

    }

    private static LocalDate stringToLocalDate(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_BR);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

    private static LocalDate stringToLocalDateReturnAPI(String strDate) {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_API);

	return LocalDate.parse(strDate, dateTimeFormatter);

    }

    private static String localDateToString(LocalDate date) {

	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_BR);

	return dateFormat.format(date);

    }

    public static String backToBusinessDayWithString(String strDate) {

	LocalDate localDate = stringToLocalDate(strDate).minusDays(1);

	backtoBeforeWeekend(localDate);

	return DateUtil.localDateToString(localDate);

    }

    public static boolean isEqualOrAfterToday(String strDate) {

	LocalDate localDate = stringToLocalDate(strDate);
	LocalDate today = LocalDate.now();

	return (localDate.equals(today) || localDate.isAfter(today));

    }

    public static String minusDaysWithString(String strDate, int days) {

	LocalDate localDate = stringToLocalDate(strDate).minusDays(days);

	backtoBeforeWeekend(localDate);

	return DateUtil.localDateToString(localDate);

    }

    private static void backtoBeforeWeekend(LocalDate localDate) {
	if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
	    DateUtil.localDateToString(localDate.minusDays(2));
	} else if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
	    DateUtil.localDateToString(localDate.minusDays(1));
	}
    }

}
