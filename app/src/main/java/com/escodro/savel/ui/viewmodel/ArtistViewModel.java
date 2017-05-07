package com.escodro.savel.ui.viewmodel;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.escodro.savel.R;
import com.escodro.savel.data.local.contract.ArtistContract;
import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.model.Artist;
import com.escodro.savel.ui.fragment.ProfileFragment;
import com.escodro.savel.ui.fragment.TimelineFragment;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * ViewModel responsible to request and provide {@link Artist} information to the descendant
 * fragments.
 * <p/>
 * Created by Igor Escodro on 05/05/17.
 */

public class ArtistViewModel extends NetworkViewModel<Artist> {

    @Inject
    ProfileFragment mArtistFragment;

    @Inject
    TimelineFragment mTimelineFragment;

    @Inject
    ArtistContract mContract;

    @Inject
    ArtistProvider mProvider;

    private FragmentManager mFragmentManager;

    private String mArtistId;

    @Inject
    public ArtistViewModel() {
    }

    public void loadArtist(String artistId) {
        mArtistId = artistId;
        loadData();
    }

    @Override
    public Observable<Artist> getObservable() {
        return mContract.getArtist(mArtistId);
    }

    @Override
    public void onResult(Artist result) {
        mProvider.storeData(result);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener getNavigationListener() {
        return item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menu_artist_profile:
                    fragment = mArtistFragment;
                    break;
                case R.id.menu_artist_timeline:
                    fragment = mTimelineFragment;
                    break;
            }
            replaceWithFragment(fragment);
            return true;
        };
    }

    /**
     * Set the {@link FragmentManager} to be used in the
     * {@link android.support.v4.app.FragmentTransaction} with descendant fragments.
     *
     * @param fragmentManager activity FragmentManager
     */
    public void setFragmentManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        replaceWithFragment(mArtistFragment);
    }

    private void replaceWithFragment(Fragment fragment) {
        if (mFragmentManager == null) {
            throw new IllegalStateException("FragmentManager is null. Did you call " +
                    "'setFragmentManager()'");
        }

        if (fragment != null) {
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }
}
