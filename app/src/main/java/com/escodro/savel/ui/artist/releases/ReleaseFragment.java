package com.escodro.savel.ui.artist.releases;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.databinding.FragmentArtistReleaseBinding;

import javax.inject.Inject;

/**
 * {@link Fragment} containing information about {@link SavelArtist} releases.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class ReleaseFragment extends Fragment {

    @Inject
    ReleaseViewModel mReleaseViewModel;

    /**
     * Default injectable constructor.
     */
    @Inject
    public ReleaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final FragmentArtistReleaseBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_artist_release, container, false);
        binding.setViewModel(mReleaseViewModel);
        return binding.getRoot();
    }
}
