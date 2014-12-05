package com.epita.mti.nuitdelinfoandroid.util;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * Convert a date into a "time ago" string
     * @param date the date
     * @return the well formed date
     */
    public static String timeAgoInWords(Date date) {
        return DateUtils.getRelativeTimeSpanString(
                date.getTime(),
                new Date().getTime(),
                DateUtils.HOUR_IN_MILLIS,
                DateUtils.FORMAT_ABBREV_ALL
        ).toString();
    }

    public static String format(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

}
