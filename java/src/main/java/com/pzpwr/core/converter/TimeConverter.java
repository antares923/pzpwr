package com.pzpwr.core.converter;

import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

    private static DateTimeFormatter formatter;
    private static Logger logger = Logger.getLogger("TimeConverter");

    public static void initialize(String dateFormat) {
        formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    public static String convertToString(LocalDateTime date) {
        logger.debug("convertToString(date: " + date + ") called");
        String convertedDate = date.toString();
        logger.debug("convertToString() returned " + convertedDate);
        return convertedDate;
    }

    public static LocalDateTime convertToLocalDateTime(String date) {
        logger.debug("convertToLocalDateTime(date: " + date + ") called");
        LocalDateTime convertedDate = LocalDateTime.parse(date, formatter);
        logger.debug("convertToLocalDateTime() returned " + convertedDate);
        return convertedDate;
    }

    public static LocalDateTime applyFormatter(LocalDateTime date) {
        logger.debug("applyFormatter(date: " + date + ") called");
        String convertedDate = convertToString(date);
        LocalDateTime returnedDate = LocalDateTime.parse(convertedDate, formatter);
        logger.debug("applyFormatter() returned " + returnedDate);
        return returnedDate;
    }
}
