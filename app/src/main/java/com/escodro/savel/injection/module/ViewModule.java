package com.escodro.savel.injection.module;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.escodro.savel.injection.qualifier.LayoutHorizontal;
import com.escodro.savel.injection.qualifier.LayoutVertical;

import dagger.Module;
import dagger.Provides;

/**
 * {@link Module} to provide the attributes related to Android views.
 * <p/>
 * Created by Igor Escodro on 12/05/17.
 */
@Module
public class ViewModule {

    @LayoutVertical
    @Provides
    LinearLayoutManager provideLinearLayoutManagerVertical(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    @LayoutVertical
    @Provides
    DividerItemDecoration provideDividerItemDecorationVertical(Context context) {
        return new DividerItemDecoration(context, LinearLayoutManager.VERTICAL);
    }

    @LayoutHorizontal
    @Provides
    LinearLayoutManager provideLinearLayoutManagerHorizontal(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @LayoutHorizontal
    @Provides
    DividerItemDecoration provideDividerItemDecorationHorizontal(Context context) {
        return new DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL);
    }
}
