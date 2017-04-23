package com.escodro.savel.data.local.repository;

import com.escodro.savel.data.model.Artist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.remote.repository.DiscogsRepository;
import com.escodro.savel.data.remote.repository.MusicBrainzRepository;
import com.escodro.savel.util.UrlParser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Local repository which wrap the content from every remote service used in the application.
 * <p/>
 * Created by Igor Escodro on 18/04/17.
 */
public class SavelRepository {

    @Inject
    MusicBrainzRepository mMusicBrainzRepository;

    @Inject
    DiscogsRepository mDiscogsRepository;

    @Inject
    public SavelRepository() {
    }

    /**
     * Get the wrapped {@link Artist} from every music service.
     *
     * @param artistId artist MBID
     *
     * @return artist wrapper
     */
    public Observable<Artist> getArtist(String artistId) {
        return mMusicBrainzRepository.getArtistInfo(artistId).
                flatMap(result -> Observable.zip(
                        Observable.just(result),
                        mDiscogsRepository.getArtist(UrlParser.getDiscogsId(result.getRelations())),
                        Artist::new));
    }

    /**
     * Get the wrapped {@link List} of {@link Artist} from
     * {@link com.escodro.savel.data.remote.service.MusicBrainzService}.
     *
     * @param artistName artist name
     *
     * @return artist wrapper
     */
    public Observable<List<Artist>> searchArtist(String artistName) {
        return mMusicBrainzRepository.searchArtist(artistName).map(
                musicBrainzArtistList -> {
                    final List<Artist> artists = new ArrayList<>();
                    for (MusicBrainzArtist mbArtist : musicBrainzArtistList.getArtists()) {
                        artists.add(new Artist(mbArtist));
                    }
                    return artists;
                });
    }
}
