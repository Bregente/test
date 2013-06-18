/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * Misc Utility functions.
 * @author richard.go
 */
public class ConverterUtils {

    /**
     * Converts a specific date to string, using the parameter format
     * @param date object to convert
     * @param format target date format
     * @return string equivalent of date
     */
    public static String dateToStr(Date date, String format) {
        if (date == null) { return ""; }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Converts a specific string to date object, using the parameter format
     * @param date object to convert
     * @param format target format
     * @return date equivalent
     */
    public static Date strToDate(String date, String format) {
        if (StringUtils.isEmpty(date)) { return null; }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Formats a specific date string to a format
     * @param date target date to convert
     * @param srcformat source format
     * @param targetFormat target format
     * @return formatted string
     */
    public static String formatDateStr(String date, String srcFormat, String targetFormat) {
        if (StringUtils.isEmpty(date)) { return ""; }
        SimpleDateFormat srcFmt = new SimpleDateFormat(srcFormat);
        SimpleDateFormat tgtFmt = new SimpleDateFormat(targetFormat);
        try {
            return tgtFmt.format(srcFmt.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Converts object to string.
     * @param obj object to convert
     * @return string equivalent
     */
    public static String objToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * Converts object to int.
     * @param obj object to convert
     * @return int equivalent
     */
    public static int objToInt(Object obj) {
        String str = objToString(obj);
        if (StringUtils.isEmpty(str)) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }
}
