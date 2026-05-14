package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) return false;
        if (username.trim().isEmpty() || password.trim().isEmpty() || dob.trim().isEmpty()) return false;
        if (!isValidDateFormat(dob)) return false;
        return "kavish".equals(username)
            && "kavish193".equals(password)
            && "2005-03-19".equals(dob);
    }

    public static boolean isValidDateFormat(String dob) {
        if (dob == null) return false;
        try {
            LocalDate.parse(dob, DateTimeFormatter.ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}