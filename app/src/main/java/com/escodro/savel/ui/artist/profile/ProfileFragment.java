package com.escodro.savel.ui.artist.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.databinding.FragmentArtistProfileBinding;

import javax.inject.Inject;

/**
 * {@link Fragment} containing information about {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */
public class ProfileFragment extends Fragment {

    @Inject
    ProfileViewModel mProfileViewModel;

    /**
     * Default injectable constructor.
     */
    @Inject
    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final FragmentArtistProfileBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_artist_profile, container, false);
        binding.setViewModel(mProfileViewModel);
        return binding.getRoot();
    }
}
