package ru.api.library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	public static String format(Date date) {
		return formatter.format(date);
	}
}
