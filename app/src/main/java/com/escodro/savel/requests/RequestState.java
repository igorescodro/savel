package com.escodro.savel.requests;

/**
 * Enum to represent the possible {@link Request} states.
 * <p/>
 * Created by IgorEscodro on 05/07/15.
 */
public enum RequestState {

    /**
     * The {@link Request} is on hold and ready to be started.
     */
    IDLE,

    /**
     * The {@link Request} has already started.
     */
    STARTED,

    /**
     * The {@link Request} has finished.
     */
    FINISHED
}
