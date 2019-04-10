/*
 * Copyright 2019 Andrej Robert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package webapi.net;

import webapi.ds.ApiException;

/**
 * This Callback is used for asynchronous Web Api requests.
 *
 * @param <T> The type of the argument provided to the {@code onResponse} method.
 */
public interface AsyncCallback<T> {

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
