package calendar.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static String convertToString(LocalDateTime date) {
        return date.toString();
    }

    public static LocalDateTime convertToLocalDateTime(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    public static LocalDateTime applyFormatter(LocalDateTime date) {
        String convertedDate = convertToString(date);
        return LocalDateTime.parse(convertedDate, formatter);
    }
}
