package com.escodro.savel.data.local.database;

import com.escodro.savel.data.local.database.model.ArtistRealm;
import com.escodro.savel.data.model.SavelArtist;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Data Access Object class o handle all the operation related to an Artist.
 * <p/>
 * Created by IgorEscodro on 07/06/17.
 */
public class ArtistDAO {

    private final DatabaseRealm mRealm;

    @Inject
    public ArtistDAO(DatabaseRealm realm) {
        mRealm = realm;
    }

    /**
     * Read from {@link ArtistRealm} database and returns the first occurrence.
     *
     * @param id {@link ArtistRealm} id
     *
     * @return first occurrence in database
     */
    public ArtistRealm readFromRealm(String id) {
        final Realm realm = mRealm.getRealmInstance();
        return findFirst(realm, id);
    }

    /**
     * Store the {@link SavelArtist} in {@link ArtistRealm} format.
     *
     * @param artist artist to be store
     *
     * @return the id from the saved artist
     */
    public String writeToRealm(SavelArtist artist) {
        Realm realm = mRealm.getRealmInstance();
        realm.executeTransaction(realm1 -> {
            final String artistId = artist.getId();
            ArtistRealm artistRealm = findFirst(realm1, artistId);
            if (artistRealm == null) {
                artistRealm = realm1.createObject(ArtistRealm.class, artistId);
            }
            artistRealm.setArtist(artist);
        });
        realm.close();
        return artist.getId();
    }

    private ArtistRealm findFirst(Realm realm, String id) {
        return realm.where(ArtistRealm.class).equalTo(ArtistRealm.ID, id).findFirst();
    }
}
