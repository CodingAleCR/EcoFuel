package info.codingalecr.ecofuel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aulate on 4/12/17.
 */

public class DateUtils {

    public static String showDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }

    public static String showDate(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(timestamp);
    }

    public static long getTime() {
        return new Date().getTime();
    }
}
