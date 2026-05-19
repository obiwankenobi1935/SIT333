package web.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtilityService {

    public static String dateAfterDays(String startDate, String daysStr) {
        if (startDate == null || daysStr == null || startDate.trim().isEmpty() || daysStr.trim().isEmpty()) {
            return null;
        }
        LocalDate date = LocalDate.parse(startDate.trim());
        long days = Long.parseLong(daysStr.trim());
        return date.plusDays(days).toString();
    }

    public static long daysBetween(String date1, String date2) {
        if (date1 == null || date2 == null || date1.trim().isEmpty() || date2.trim().isEmpty()) {
            return Long.MIN_VALUE;
        }
        LocalDate d1 = LocalDate.parse(date1.trim());
        LocalDate d2 = LocalDate.parse(date2.trim());
        return ChronoUnit.DAYS.between(d1, d2);
    }
}