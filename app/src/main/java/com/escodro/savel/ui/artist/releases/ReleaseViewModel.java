package com.escodro.savel.ui.artist.releases;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.escodro.savel.data.local.contract.ReleaseContract;
import com.escodro.savel.data.local.provider.ArtistProvider;
import com.escodro.savel.data.model.SavelArtist;
import com.escodro.savel.databinding.ItemArtistReleaseBinding;
import com.escodro.savel.injection.qualifier.LayoutHorizontal;
import com.escodro.savel.util.viewholder.BindingHolder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * ViewModel responsible to provide {@link SavelArtist} release information to
 * {@link ReleaseFragment}.
 * <p/>
 * Created by Igor Escodro on 11/05/17.
 */
public class ReleaseViewModel {

    @Inject
    ReleaseContract mContract;

    @Inject
    ReleaseRecyclerAdapter mAlbumAdapter;

    @Inject
    ReleaseRecyclerAdapter mSingleAdapter;

    @Inject
    @LayoutHorizontal
    Provider<LinearLayoutManager> mAlbumLayoutProvider;

    @Inject
    @LayoutHorizontal
    Provider<LinearLayoutManager> mSingleLayoutProvider;

    /**
     * Default injectable constructor to be used in {@link ReleaseFragment}.
     */
    @Inject
    public ReleaseViewModel(ArtistProvider provider) {
//        provider.getObservable().subscribe(this::updateReleaseList);
    }

//    private void updateReleaseList(SavelArtist artist) {
//        mContract.setReleaseList(artist.getReleases());
//        mAlbumAdapter.updateReleaseList(mContract.getAlbumReleases());
//        mSingleAdapter.updateReleaseList(mContract.getSingleReleases());
//    }

    public RecyclerView.Adapter<BindingHolder<ItemArtistReleaseBinding>> getAlbumAdapter() {
        return mAlbumAdapter;
    }

    public LinearLayoutManager getAlbumLayoutManager() {
        return mAlbumLayoutProvider.get();
    }

    public RecyclerView.Adapter<BindingHolder<ItemArtistReleaseBinding>> getSingleAdapter() {
        return mSingleAdapter;
    }

    public LinearLayoutManager getSingleLayoutManager() {
        return mSingleLayoutProvider.get();
    }
}
