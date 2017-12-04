package info.codingalecr.ecofuel.ui;

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
}
