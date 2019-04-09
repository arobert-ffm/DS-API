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


import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import webapi.base.ParameterizedCallback;
import webapi.ds.ApiCallback;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;

/**
 * A wrapper around the OkHttpClient to generalize the http request execution.
 */
public final class HttpClientAdapter {

    private final String httpError = "HTTP %d: %s";

    private OkHttpClient client;
    private ObjectMapper mapper;

    /**
     * @throws NoSuchAlgorithmException is called when TLS protocol is not supported
     * @throws KeyManagementException   is called when the TLS initialization failed
     */
    public HttpClientAdapter() throws NoSuchAlgorithmException, KeyManagementException {
        setClient(null);
        mapper = new ObjectMapper();
    }

    /**
     * Execute a request for the given {@code uri}.
     *
     * @param uri  request
     * @param type response type
     * @return Http response from type {@code type}
     * @throws ClientException is called when executing the request or when retrieving/parsing the response failed. See
     *                         {@link ClientErrorContract} for a list of errors.
     */
    public <T> T executeRequest(String uri, Class<T> type) throws ClientException {
        Response response;

        try {
            response = client.newCall(uriToRequest(uri)).execute();
        } catch (IOException e) {
            throw new ClientException(e, ClientErrorContract.REQUEST_EXECUTE);
        }

        if (!response.isSuccessful()) {
            throw new ClientException(String.format(httpError, response.code(), response.message()),
                    ClientErrorContract.RESPONSE_NOT_SUCCESSFUL);
        }

        String result;
        try {
            result = response.body().string();
        } catch (IOException e) {
            throw new ClientException(e, ClientErrorContract.RESPONSE_RECEIVE);
        }

        try {
            return mapper.readValue(result, type);
        } catch (IOException e) {
            throw new ClientException(e, ClientErrorContract.RESPONSE_PARSE);
        }
    }

    /**
     * Execute a request asynchronously for the given {@code uri}.
     *
     * @param uri              request
     * @param responseType     response type
     * @param responseCallback provides either the response or an exception
     */
    public <T, S> void executeRequestAsync(String uri, Class<T> responseType,
                                           ParameterizedCallback<T, S> mapCallback, ApiCallback<S> responseCallback) {
        client.newCall(uriToRequest(uri)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseCallback.onFailure(new ClientException(e, ClientErrorContract.REQUEST_EXECUTE));
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (!response.isSuccessful()) {
                    responseCallback.onFailure(new ClientException(String.format(httpError, response.code(),
                            response.message()), ClientErrorContract.RESPONSE_NOT_SUCCESSFUL));
                }

                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    responseCallback.onFailure(new ClientException(e, ClientErrorContract.RESPONSE_RECEIVE));
                }

                try {
                    T value = mapper.readValue(result, responseType);
                    S data = mapCallback.call(value);
                    responseCallback.onResponse(data);
                } catch (IOException e) {
                    responseCallback.onFailure(new ClientException(e, ClientErrorContract.RESPONSE_PARSE));
                }
            }
        });
    }

    /**
     * Closes the Http Client.
     *
     * @throws IOException An error occurred while closing the client
     */
    public void close() throws IOException {
        // Shutdown the dispatcher's executor net
        client.dispatcher().executorService().shutdown();
        // Clear the connection pool, daemon thread may not exit immediately
        client.connectionPool().evictAll();
        // Close cache if set, produces an error if used on a closed cache
        if (client.cache() != null && !client.cache().isClosed()) {
            client.cache().close();
        }
    }

    /**
     * Set a new {@link OkHttpClient} instance. If null the default implementation is used.
     *
     * @param client new {@link OkHttpClient} instance or null
     * @throws KeyManagementException   is called when TLS protocol is not supported
     * @throws NoSuchAlgorithmException is called when the TLS initialization failed
     */
    public void setClient(OkHttpClient client) throws KeyManagementException, NoSuchAlgorithmException {
        if (client == null) {
            this.client = new OkHttpClient.Builder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .readTimeout(Duration.ofSeconds(10))
                    .writeTimeout(Duration.ofSeconds(10))
                    // todo looging impl
                    .addInterceptor(new HttpLoggingInterceptor())
                    .sslSocketFactory(getSSLSocketFactory(), getX509TrustManager())
                    .hostnameVerifier((hostname, session) -> true)
                    .build();
        } else {
            this.client = client;
        }
    }

    private Request uriToRequest(String uri) {
        Request.Builder builder = new Request.Builder();
        return builder.url(uri)
                .get()
                .build();
    }

    private X509TrustManager getX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    /**
     * @throws NoSuchAlgorithmException when failed to construct a TLS instance with
     *                                  {@link SSLContext#getInstance(String)}.
     * @throws KeyManagementException   when failed to initialize the TLS instance with
     *                                  {@link SSLContext#init(KeyManager[], TrustManager[], SecureRandom)}
     */
    private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{
                getX509TrustManager()
        }, null);
        return sslContext.getSocketFactory();
    }

}
