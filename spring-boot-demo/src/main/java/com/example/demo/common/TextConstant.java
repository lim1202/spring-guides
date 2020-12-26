package com.example.demo.common;

import java.time.format.DateTimeFormatter;

public class TextConstant {

    private TextConstant() {
        throw new IllegalStateException("Constant class");
    }

    public static final DateTimeFormatter standardDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter standardDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter standardYearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public static final String DELIMITER = ",";

}
