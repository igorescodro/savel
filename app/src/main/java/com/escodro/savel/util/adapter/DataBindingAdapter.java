package com.escodro.savel.util.adapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Class containing the custom {@link BindingAdapter} attributes for Data Binding.
 *
 * Created by Igor Escodro on 19/04/17.
 */
public class DataBindingAdapter {

    /**
     * Custom attribute to load image in {@link ImageView} from an URL.
     *
     * @param imageView image view to apply the image
     * @param resource  url resource
     */
    @BindingAdapter("bind:image")
    public static void setImageResource(ImageView imageView, String resource) {
        if (TextUtils.isEmpty(resource)) {
            return;
        }

        Picasso.with(imageView.getContext())
                .load(resource)
                .fit()
                .centerCrop()
                .into(imageView);
    }
}
