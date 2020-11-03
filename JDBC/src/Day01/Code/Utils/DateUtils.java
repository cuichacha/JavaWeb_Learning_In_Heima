package Day01.Code.Utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtils {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    private static SimpleDateFormat simpleDateFormat;
    private static Date date;

    private DateUtils() {
    }

    public static String date2String(Date date, String formatPattern) {
        simpleDateFormat = new SimpleDateFormat(formatPattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static String date2String(Date date) {
        return date2String(date, DEFAULT_PATTERN);
    }

    public static Date string2Date(String str, String formatPattern) {
        simpleDateFormat = new SimpleDateFormat(formatPattern);

        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date string2Date(String str) {
        return string2Date(str, DEFAULT_PATTERN);
    }
}
