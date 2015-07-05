package com.escodro.savel.requests;

import android.os.AsyncTask;

import com.escodro.savel.data.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Manager responsible to handle all the {@link Request}s, ensuring all will be executed in a
 * separate Thread and notifying when every {@link Request} is finished.
 * <p/>
 * Created by IgorEscodro on 28/06/15.
 */
public class RequestManager {

    /**
     * {@link HashMap} to store all the {@link Request}.
     */
    private final HashMap<String, Request> mRequestHashMap;

    /**
     * {@link Semaphore} reference to handle the permits and assure when every request is finished.
     */
    private Semaphore mSemaphore;

    /**
     * {@link OnRequestFinishListener} reference to be notified when every request is finished.
     */
    private OnRequestFinishListener mListener;

    /**
     * {@link Data} reference to be created with all the responses from the APIs.
     */
    private Data mData;

    /**
     * Create a new instance of {@link RequestManager}.
     */
    public RequestManager() {
        mRequestHashMap = new HashMap<>();
        mData = new Data();
    }

    /**
     * Add a {@link Request} in the list to be executed.
     *
     * @param request {@link Request} to be executed
     */
    public void add(Request request) {
        mRequestHashMap.put(request.getRequestId(), request);
    }

    /**
     * Execute all the {@link Request}s in the List.
     *
     * @param listener listener to be notified when every request is finished
     */
    public void execute(OnRequestFinishListener listener) {
        mListener = listener;
        mSemaphore = new Semaphore(mRequestHashMap.size());
        mSemaphore.drainPermits();
        new CreateRequest().execute();
    }

    /**
     * Interface to be notified when every {@link Request} in the {@link RequestManager} list is
     * finished.
     */
    public interface OnRequestFinishListener {

        /**
         * Method notified with he {@link Data} object created when every {@link Request} in the
         * {@link RequestManager} list is finished.
         *
         * @param data {@link Data} instance
         */
        void onResponseCreated(Data data);
    }

    /**
     * Create a separate Thread to execute all the {@link Request}s in asynchronous way.
     */
    private class CreateRequest extends AsyncTask<Void, Void, Void> {

        /**
         * Start each {@link Request}s individually and after that, tries do acquire each {@link
         * Semaphore} permit back. Acquiring all the permits back means all the {@link Request}s has
         * already finished.
         *
         * @param voids params
         *
         * @return null
         */
        @Override
        protected Void doInBackground(Void... voids) {
            for (Map.Entry<String, Request> entry : mRequestHashMap.entrySet()) {
                final Request request = mRequestHashMap.get(entry.getKey());
                request.startRequest(mSemaphore, mData);
            }

            for (int i = 0; i < mRequestHashMap.size(); i++) {
                try {
                    mSemaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         * When every {@link Request} is finished, it notifies the listener.
         *
         * @param aVoid result
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            mListener.onResponseCreated(mData);
        }
    }
}
