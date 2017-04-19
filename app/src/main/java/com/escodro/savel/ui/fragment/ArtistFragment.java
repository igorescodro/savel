package com.escodro.savel.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.databinding.FragmentArtistBinding;
import com.escodro.savel.ui.viewmodel.ArtistViewModel;

import javax.inject.Inject;

/**
 * {@link Fragment} containing information about {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistFragment extends Fragment {

    @Inject
    ArtistViewModel mArtistViewModel;

    /**
     * Default injectable constructor.
     */
    @Inject
    public ArtistFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final FragmentArtistBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_artist, container, false);
        binding.setViewModel(mArtistViewModel);
        mArtistViewModel.loadData("b7539c32-53e7-4908-bda3-81449c367da6");
        return binding.getRoot();
    }
}
