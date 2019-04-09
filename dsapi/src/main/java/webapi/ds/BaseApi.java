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

package webapi.ds;

import webapi.model.auth.AuthLogin;
import webapi.model.auth.AuthLogout;
import webapi.model.info.ApiInfo;
import webapi.model.info.DsApi;
import webapi.net.ClientException;
import webapi.net.HttpClientAdapter;

import java.util.List;
import java.util.Map;

/**
 * Base class to access the Web Api. Provides the functionality to access
 * the Info and Auth Web Api of the DiskStation.
 */
public class BaseApi implements ApiContract {

    private UriBuilder uriBuilder;
    private HttpClientAdapter httpClient;

    public BaseApi(UriBuilder uriBuilder, HttpClientAdapter httpClient) {
        this.uriBuilder = uriBuilder;
        this.httpClient = httpClient;
    }


    /**
     * Provides all supported Apis.
     *
     * @return Api List
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public List<DsApi> apiInfo() throws ClientException, ApiException {
        String uri = uriBuilder.getUri(INFO_CGI, INFO_API,
                INFO_VERSION, INFO_METHOD,
                Map.of(INFO_PARAM_QUERY, INFO_PARAM_QUERY_VALUE));
        ApiInfo apiInfo = httpClient.executeRequest(uri, ApiInfo.class);

        if (!apiInfo.isSuccess()) {
            throw new ApiException(ApiErrorParser.parseCommonError(apiInfo.getError().getCode()));
        }

        return apiInfo.getData().getApiList();
    }

    /**
     * Provides all supported Apis. The request is executed Asynchronous.
     *
     * @param responseCallback provides either an Api list or an exception
     */
    public void apiInfo(ApiCallback<List<DsApi>> responseCallback) {
        String uri = uriBuilder.getUri(INFO_CGI, INFO_API,
                INFO_VERSION, INFO_METHOD,
                Map.of(INFO_PARAM_QUERY, INFO_PARAM_QUERY_VALUE));
        httpClient.executeRequestAsync(uri, ApiInfo.class,
                response -> response.getData().getApiList(), responseCallback);
    }

    /**
     * Login into a {@code session}.
     *
     * @param account account name
     * @param passwd  account password
     * @param session session name
     * @return Session ID
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public String login(String account, String passwd, String session) throws ClientException, ApiException {
        String uri = uriBuilder.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGIN_VERSION, AUTH_LOGIN_METHOD,
                Map.of(AUTH_PARAM_ACCOUNT, account,
                        AUTH_PARAM_PASSWD, passwd,
                        AUTH_PARAM_SESSION, session,
                        AUTH_PARAM_FORMAT, AUTH_PARAM_FORMAT_VALUE));
        AuthLogin authLogin = httpClient.executeRequest(uri, AuthLogin.class);

        if (!authLogin.isSuccess()) {
            int errorCode = authLogin.getError().getCode();
            String desc = ApiErrorParser.isCommonError(errorCode) ?
                    ApiErrorParser.parseCommonError(errorCode) : ApiErrorParser.parseAuthError(errorCode);
            throw new ApiException(desc);
        }

        return authLogin.getData().getSid();
    }

    /**
     * Login into a {@code session}. The request is executed Asynchronous.
     *
     * @param account  account name
     * @param passwd   account password
     * @param session  session name
     * @param callback provides either a session id or an exception
     */
    public void login(String account, String passwd, String session, ApiCallback<String> callback) {
        String uri = uriBuilder.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGIN_VERSION, AUTH_LOGIN_METHOD,
                Map.of(AUTH_PARAM_ACCOUNT, account,
                        AUTH_PARAM_PASSWD, passwd,
                        AUTH_PARAM_SESSION, session,
                        AUTH_PARAM_FORMAT, AUTH_PARAM_FORMAT_VALUE));
        httpClient.executeRequestAsync(uri, AuthLogin.class,
                response -> response.getData().getSid(), callback);
    }

    /**
     * Logout out from a {@code session}.
     *
     * @param session session name
     * @return True if logout was successful
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public boolean logout(String session) throws ClientException, ApiException {
        String uri = uriBuilder.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGOUT_VERSION, AUTH_LOGOUT_METHOD,
                Map.of(AUTH_PARAM_SESSION, session));
        AuthLogout authLogout = httpClient.executeRequest(uri, AuthLogout.class);

        if (!authLogout.isSuccess()) {
            int errorCode = authLogout.getError().getCode();
            String desc = ApiErrorParser.isCommonError(errorCode) ?
                    ApiErrorParser.parseCommonError(errorCode) : ApiErrorParser.parseAuthError(errorCode);
            throw new ApiException(desc);
        }

        return true;
    }

    /**
     * Logout out from a {@code session}. The request is executed Asynchronous.
     *
     * @param session  session name
     * @param callback provides either an empty response when successful or an exception
     */
    public void logout(String session, ApiCallback<Void> callback) {
        String uri = uriBuilder.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGOUT_VERSION, AUTH_LOGOUT_METHOD,
                Map.of(AUTH_PARAM_SESSION, session));
        httpClient.executeRequestAsync(uri, AuthLogout.class, response -> null, callback);
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
}
