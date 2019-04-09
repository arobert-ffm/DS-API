package webapi.ds;

import webapi.net.ClientException;

/**
 * This Callback is used for asynchronous Web Api requests.
 *
 * @param <T> The type of the argument provided to the {@code onResponse} method.
 */
public interface ApiCallback<T> {

    /**
     * Called when the request is unsuccessful. The exception can be:
     * {@link ClientException} when something went wrong during the http request
     * {@link ApiException} when the Api request was not successful
     *
     * @param e provides information about the failure
     */
    void onFailure(Exception e);

    /**
     * Called when the request was successful.
     *
     * @param response provides the response to the request
     */
    void onResponse(T response);

}
