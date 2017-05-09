package com.escodro.savel.ui.artist.timeline;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.escodro.savel.R;
import com.escodro.savel.databinding.FragmentArtistTimelineBinding;

import javax.inject.Inject;

/**
 * {@link Fragment} containing the Timeline of {@link com.escodro.savel.data.model.Artist}.
 * <p/>
 * Created by IgorEscodro on 06/05/17.
 */
public class TimelineFragment extends Fragment {

    @Inject
    TimelineViewModel mTimelineViewModel;

    /**
     * Default injectable constructor.
     */
    @Inject
    public TimelineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final FragmentArtistTimelineBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_artist_timeline, container, false);
        binding.setViewModel(mTimelineViewModel);
        return binding.getRoot();
    }
}
