package com.kravchenko.booking.utils;

import java.util.regex.Pattern;

public class Validator {
    public static final String EMAIL_PATTERN = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isItEmail(String string) {
        if (string == null) {
            throw new NullPointerException("Parameter is null");
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(string).matches();
    }
}
