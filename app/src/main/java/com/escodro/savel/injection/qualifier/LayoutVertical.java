package com.escodro.savel.injection.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Qualifier to identify that the layout is in VERTICAL orientation.
 * <p/>
 * Created by Igor Escodro on 12/05/17.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface LayoutVertical {
}
