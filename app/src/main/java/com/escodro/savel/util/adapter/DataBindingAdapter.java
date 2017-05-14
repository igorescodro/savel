package com.escodro.savel.util.adapter;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Class containing the custom {@link BindingAdapter} attributes for Data Binding.
 * <p>
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
        if (!TextUtils.isEmpty(resource)) {
            Picasso.with(imageView.getContext())
                    .load(resource)
                    .fit()
                    .centerCrop()
                    .into(imageView);

        } else {
            imageView.setImageDrawable(null);
        }
    }

    /**
     * Custom attribute to set the {@link RecyclerView.Adapter} in a {@link RecyclerView}.
     *
     * @param recyclerView RecyclerView to receive the adapter
     * @param adapter      adapter to be set
     * @param <T>          type of view holder
     */
    @BindingAdapter("bind:adapter")
    public static <T extends RecyclerView.ViewHolder> void setRecyclerViewAdapter(
            RecyclerView recyclerView, RecyclerView.Adapter<T> adapter) {
        recyclerView.setAdapter(adapter);
    }

    /**
     * Custom attribute to set the {@link RecyclerView.LayoutManager} in a {@link RecyclerView}.
     *
     * @param recyclerView  RecyclerView to receive the layout manager
     * @param layoutManager layout manager to be set
     */
    @BindingAdapter("bind:layout_manager")
    public static void setRecyclerViewLayoutManager(RecyclerView recyclerView,
                                                    RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    /**
     * Custom attribute to set the {@link DividerItemDecoration} in a {@link RecyclerView}.
     *
     * @param recyclerView RecyclerView to receive the item decoration
     * @param decoration   decoration to be set
     */
    @BindingAdapter("bind:item_decoration")
    public static void setRecyclerViewItemDecorator(RecyclerView recyclerView,
                                                    RecyclerView.ItemDecoration decoration) {
        recyclerView.addItemDecoration(decoration);
    }

    /**
     * Custom attribute to set a drawable resource in a {@link ImageView}.
     *
     * @param imageView ImageView to receive the drawable resource
     * @param resource  drawable resource id
     */
    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    /**
     * Custom attribute to set an {@link TextView.OnEditorActionListener} in a {@link EditText}.
     *
     * @param editText EditText to receive the listener
     * @param listener listener to be set
     */
    @BindingAdapter({"bind:editor_action"})
    public static void setEditorAction(EditText editText,
                                       TextView.OnEditorActionListener listener) {
        editText.setOnEditorActionListener(listener);
    }

    /**
     * Custom attribute to set an {@link BottomNavigationView.OnNavigationItemSelectedListener}
     * in a {@link BottomNavigationView}.
     *
     * @param view     BottomNavigationView to receive the listener
     * @param listener listener to be set
     */
    @BindingAdapter({"bind:adapter"})
    public static void setBottomViewListener(BottomNavigationView view,
                                             BottomNavigationView
                                                     .OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }
}
