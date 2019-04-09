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

package webapi;

import webapi.ds.UriBuilder;
import webapi.net.HttpClientAdapter;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Assists in initialization of the Web Api.
 * todo add 2-step verification
 */
public final class WebApi {

    private UriBuilder uriBuilder;
    private HttpClientAdapter httpClient;

    private GetApi getApi;


    /**
     * Initializes the DiskStation interfaces.
     *
     * @param host Address of the DiskStation
     * @param port Port of the DiskStation, if null the default port is used
     * @param ssl  If true then https is used, otherwise http
     * @throws KeyManagementException   is called when TLS protocol is not supported
     * @throws NoSuchAlgorithmException is called when the TLS initialization failed
     */
    public WebApi(String host, String port, boolean ssl) throws KeyManagementException, NoSuchAlgorithmException {
        uriBuilder = new UriBuilder(host, port, ssl);
        httpClient = new HttpClientAdapter();

        getApi = new GetApi(uriBuilder, httpClient);
    }

    public UriBuilder getUriBuilder() {
        return uriBuilder;
    }

    public void setUriBuilder(UriBuilder uriBuilder) {
        this.uriBuilder = uriBuilder;
    }

    public HttpClientAdapter getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClientAdapter httpClient) {
        this.httpClient = httpClient;
    }

    public GetApi getGetApi() {
        return getApi;
    }
}
