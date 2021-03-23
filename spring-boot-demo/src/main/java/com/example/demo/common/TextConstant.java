package com.example.demo.common;

import java.time.format.DateTimeFormatter;

public class TextConstant {

    private TextConstant() {
        throw new IllegalStateException("Constant class");
    }

    public static final String STANDARD_YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd";
    public static final String STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter standardDateTimeFormatter = DateTimeFormatter.ofPattern(STANDARD_DATETIME_FORMAT);
    public static final DateTimeFormatter standardDateFormatter = DateTimeFormatter.ofPattern(STANDARD_DATE_FORMAT);
    public static final DateTimeFormatter standardYearMonthFormatter = DateTimeFormatter.ofPattern(STANDARD_YEAR_MONTH_FORMAT);

    public static final String DELIMITER = ",";

}
