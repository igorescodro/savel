package com.escodro.savel.util.adapter;

import com.escodro.savel.data.remote.service.MusicBrainzService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import timber.log.Timber;

/**
 * Class to convert different formatted dates in milliseconds, due the discrepancy between the
 * date format in the REST APIs.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class DateConverter {

    /**
     * Private constructor to avoid instantiation.
     */
    private DateConverter() {
    }

    /**
     * Convert an formatted time String to time in milliseconds based on the given format.
     *
     * @param formattedDate the formatted date in string
     * @param format        format to be parsed
     *
     * @return time in milliseconds
     */
    public static long timeToMillis(String formattedDate, String format) {
        long timeInMillis = 0;
        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(formattedDate));
            timeInMillis = cal.getTimeInMillis();
        } catch (ParseException e) {
            Timber.e("Could not format the given date: " + formattedDate + " using the format: "
                    + format);
        }
        return timeInMillis;
    }

    /**
     * Convert an formatted time String to time in milliseconds based on the given format, trying
     * the possible formats given in the array. This method is needed since
     * {@link MusicBrainzService#getReleaseGroupByArtistId(String)} does not have a pattern to
     * return the date.
     *
     * @param formattedDate   the formatted date in string
     * @param possibleFormats array of possible formats to be parsed
     *
     * @return time in milliseconds
     */
    public static long timeToMillis(String formattedDate, String[] possibleFormats) {
        long timeInMillis = 0;
        final Calendar cal = Calendar.getInstance();
        for (String format : possibleFormats) {
            try {
                final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
                cal.setTime(sdf.parse(formattedDate));
                timeInMillis = cal.getTimeInMillis();
            } catch (ParseException e) {
                // Do nothing.
            }
        }
        return timeInMillis;
    }

    /**
     * Convert from Unix Timestamp to milliseconds.
     *
     * @param formattedDate the formatted date in string
     *
     * @return time in milliseconds
     */
    public static long unixTimestampToMillis(String formattedDate) {
        return Long.valueOf(formattedDate) * 1000;
    }

}
