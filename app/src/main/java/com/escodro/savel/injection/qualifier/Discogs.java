package com.escodro.savel.injection.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Qualifier to identify the injections related to
 * {@link com.escodro.savel.data.remote.service.DiscogsService}.
 * <p/>
 * Created by Igor Escodro on 19/04/17.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Discogs {
}
