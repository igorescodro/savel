package com.escodro.savel.util.adapter;

import android.content.Context;
import android.text.format.DateUtils;

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

    private final Context mContext;

    /**
     * Default injectable constructor.
     */
    @Inject
    public DateConverter(Context context) {
        mContext = context;
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
     * Convert from Unix Timestamp to milliseconds.
     *
     * @param formattedDate the formatted date in string
     *
     * @return time in milliseconds
     */
    public long unixTimestampToMillis(String formattedDate) {
        return Long.valueOf(formattedDate) * 1000;
    }

    /**
     * Return the relative date based on the current date. E.g: "10:18AM" if the occurrence
     * occurred today and "May 10" if occurred yesterday.
     *
     * @param timeInMillis time in milliseconds
     *
     * @return formatted relative date
     */
    public String getRelativeDateTimeString(long timeInMillis) {
        return DateUtils.getRelativeTimeSpanString(
                mContext,
                timeInMillis,
                false).toString();
    }
}
