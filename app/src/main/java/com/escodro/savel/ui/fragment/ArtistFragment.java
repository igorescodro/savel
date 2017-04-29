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
import com.escodro.savel.ui.activity.ArtistActivity;
import com.escodro.savel.ui.viewmodel.ArtistViewModel;

import javax.inject.Inject;

/**
 * {@link Fragment} containing information about {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by Igor Escodro on 17/04/17.
 */

public class ArtistFragment extends Fragment {

    private String mArtistId;

    @Inject
    ArtistViewModel mArtistViewModel;

    /**
     * Default injectable constructor.
     */
    @Inject
    public ArtistFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle bundle = this.getArguments();
        if (bundle != null) {
            mArtistId = bundle.getString(ArtistActivity.EXTRA_ARTIST_ID, null);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final FragmentArtistBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_artist, container, false);
        binding.setViewModel(mArtistViewModel);
        mArtistViewModel.loadArtist(mArtistId);
        return binding.getRoot();
    }
}
