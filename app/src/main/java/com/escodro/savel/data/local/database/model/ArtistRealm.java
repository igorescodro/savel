package com.escodro.savel.data.local.database.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.escodro.savel.data.model.SavelArtist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * {@link RealmObject} containing all the fields related to {@link SavelArtist}.
 * <p>
 * Created by IgorEscodro on 07/06/17.
 */
public class ArtistRealm extends RealmObject {

    public static final String ID = "id";

    @PrimaryKey
    private String id;

    private String name;

    private String bio;

    public void setArtist(@NonNull SavelArtist artist) {
        name = artist.getName();
        bio = artist.getBio();
    }

    public String getId() {
        return id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getBio() {
        return bio;
    }
}
