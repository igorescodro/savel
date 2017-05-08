package com.escodro.savel.ui.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Class to convert different formatted dates in milliseconds, due the discrepancy between the
 * date format in the REST APIs.
 * <p/>
 * Created by Igor Escodro on 08/05/17.
 */
public class DateConverter {

    /**
     * Default injectable constructor.
     */
    @Inject
    public DateConverter() {
    }

    /**
     * Convert an formatted time String to time in milliseconds based on the given format.
     *
     * @param formattedDate the formatted date in string
     * @param format        format to be parsed
     *
     * @return time in milliseconds
     */
    public long timeToMillis(String formattedDate, String format) {
        long timeInMillis = 0;
        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
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
     * Convert from Unix Timestamp to milliseconds.
     *
     * @param formattedDate the formatted date in string
     *
     * @return time in milliseconds
     */
    public long unixTimestampToMillis(String formattedDate) {
        return Long.valueOf(formattedDate) * 1000;
    }
}
