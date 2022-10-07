package online.bookStore.utils;

import java.util.Date;

public class DateUtil {
    public static Date OneDay(){
        return new Date(System.currentTimeMillis() * 1000 * 60 * 60 * 24);
    }
}
