package com.escodro.savel.ui.common;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;

import com.escodro.savel.R;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class to handle the {@link CustomTabsIntent}, opening links in the Google Chrome application
 * with {@link com.escodro.savel.SavelApplication} look and feel.
 * <p/>
 * Created by Igor Escodro on 09/05/17.
 *
 * @see <a href="https://segunfamisa.com/posts/chrome-custom-tabs">Chrome Custom Tabs in Android</a>
 */
@Singleton
public class CustomTabsHandler {

    private CustomTabsIntent mCustomTabsIntent;

    private Context mContext;

    @Inject
    public CustomTabsHandler(Context context) {
        mContext = context;
        final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        final int primaryColor = ContextCompat.getColor(context, R.color.colorPrimary);
        final int secondaryColor = ContextCompat.getColor(context, R.color.colorPrimaryDark);

        builder.setToolbarColor(primaryColor);
        builder.setSecondaryToolbarColor(secondaryColor);

        mCustomTabsIntent = builder.build();
    }

    /**
     * Launch the given url
     *
     * @param url url to be launched
     */
    public void launchUrl(String url) {
        final Uri uri = Uri.parse(url);
        mCustomTabsIntent.launchUrl(mContext, uri);
    }
}
