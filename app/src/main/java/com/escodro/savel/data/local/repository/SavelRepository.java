package com.escodro.savel.data.local.repository;

import com.escodro.savel.data.model.Artist;
import com.escodro.savel.data.model.musicbrainz.MusicBrainzArtist;
import com.escodro.savel.data.remote.repository.DiscogsRepository;
import com.escodro.savel.data.remote.repository.InstagramRepository;
import com.escodro.savel.data.remote.repository.MusicBrainzRepository;
import com.escodro.savel.data.remote.repository.SpotifyRepository;
import com.escodro.savel.data.remote.repository.TwitterRepository;
import com.escodro.savel.util.adapter.RelationParser;

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
    TwitterRepository mTwitterRepository;

    @Inject
    SpotifyRepository mSpotifyRepository;

    @Inject
    InstagramRepository mInstaRepository;

    @Inject
    RelationParser mRelationParser;

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
        return mMusicBrainzRepository.getArtistInfo(artistId)
                .flatMap(result -> {
                    mRelationParser.setRelationList(result.getRelations());
                    return Observable.zip(
                            Observable.just(result),
                            mDiscogsRepository.getArtist(mRelationParser.getDiscogsId()),
                            mTwitterRepository.getArtistTimeline(mRelationParser.getTwitterId()),
                            mSpotifyRepository.getArtistInfo(mRelationParser.getSpotifyId()),
                            mInstaRepository.getArtistTimeline(mRelationParser.getInstagramId()),
                            Artist::new);
                });
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
