package com.escodro.savel.ui.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.escodro.savel.R;
import com.escodro.savel.databinding.ActivitySearchBinding;
import com.escodro.savel.injection.Injector;

import javax.inject.Inject;

/**
 * {@link AppCompatActivity} with the flow to search {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by Igor Escodro on 24/04/17.
 */
public class SearchActivity extends AppCompatActivity {

    @Inject
    SearchViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.getApplicationComponent().inject(this);
        final ActivitySearchBinding binding = DataBindingUtil.setContentView(this, R.layout
                .activity_search);
        binding.setViewModel(mViewModel);
    }
}
