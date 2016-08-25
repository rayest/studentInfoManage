package cn.rayest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rayest on 2016/8/25 0025.
 */
public class DateUtil {
    public static String formatDate(Date date, String format){
        String result = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        if (date != null){
            result = simpleDateFormat.format(date);
        }
        return result;
    }
}
