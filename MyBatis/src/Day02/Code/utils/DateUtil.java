package Day02.Code.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    private static SimpleDateFormat simpleDateFormat;

    private DateUtil() {
    }

    public static String date2String(Date date, String pattern) {
        simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static String date2String(Date date) {
        return date2String(date, DEFAULT_PATTERN);
    }

    public static Date String2Date(String str, String format) {
        Date date = null;
        simpleDateFormat = new SimpleDateFormat(format);
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date String2Date(String str) {
        return String2Date(str, DEFAULT_PATTERN);
    }
}
