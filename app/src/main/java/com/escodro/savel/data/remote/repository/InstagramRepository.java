package com.escodro.savel.data.remote.repository;

import android.support.annotation.NonNull;

import com.escodro.savel.data.model.SavelInstagram;
import com.escodro.savel.data.model.instagram.InstagramItem;
import com.escodro.savel.data.model.instagram.InstagramTimeline;
import com.escodro.savel.data.remote.service.InstagramService;
import com.escodro.savel.injection.qualifier.Instagram;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Repository to connect to {@link InstagramService}
 * <p/>
 * Created by Igor Escodro on 04/05/17.
 */
public class InstagramRepository {

    private final InstagramService mService;

    @Inject
    Provider<SavelInstagram> mInstagramProvider;

    @Inject
    public InstagramRepository(@Instagram Retrofit retrofit) {
        mService = retrofit.create(InstagramService.class);
    }

    /**
     * Get a {@link InstagramTimeline} from {@link InstagramService}. If an
     * error occur during the request, a empty {@link InstagramTimeline} will be returned.<br>
     *
     * @param username artist Instagram username
     *
     * @return observable of Instagram timeline
     */
    public Observable<List<SavelInstagram>> getArtistTimeline(String username) {
        return mService.getArtistTimeline(username)
                .map(convertToInstagramList())
                .onErrorReturnItem(new ArrayList<>())
                .subscribeOn(Schedulers.newThread());
    }

    @NonNull
    private Function<InstagramTimeline, List<SavelInstagram>> convertToInstagramList() {
        return instagramTimeline -> {
            final List<SavelInstagram> timeline = new ArrayList<>();
            final List<InstagramItem> items = instagramTimeline.getItems();
            if (items != null) {
                for (InstagramItem item : items) {
                    final SavelInstagram instagram = mInstagramProvider.get();
                    instagram.setInstagramItem(item);
                    timeline.add(instagram);
                }
            }
            return timeline;
        };
    }
}
