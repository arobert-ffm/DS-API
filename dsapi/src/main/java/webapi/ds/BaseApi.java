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

import webapi.model.auth.LoginResponse;
import webapi.model.auth.LogoutResponse;
import webapi.model.info.ApiDesc;
import webapi.model.info.InfoResponse;
import webapi.net.AsyncCallback;
import webapi.net.ClientAdapter;
import webapi.net.ClientException;
import webapi.net.UriAdapter;

import java.util.List;
import java.util.Map;

/**
 * Base class to access the Web Api. Provides the functionality to access
 * the Info and Auth Web Api of the DiskStation.
 */
public class BaseApi implements ApiContract {

    private UriAdapter uriAdapter;
    private ClientAdapter httpClient;

    public BaseApi(UriAdapter uriAdapter, ClientAdapter httpClient) {
        this.uriAdapter = uriAdapter;
        this.httpClient = httpClient;
    }


    /**
     * Provides all supported Apis.
     *
     * @return Api List
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public List<ApiDesc> apiInfo() throws ClientException, ApiException {
        String uri = uriAdapter.getUri(INFO_CGI, INFO_API,
                INFO_VERSION, INFO_METHOD,
                Map.of(INFO_PARAM_QUERY, INFO_PARAM_QUERY_VALUE));
        InfoResponse infoResponse = httpClient.executeRequest(uri, InfoResponse.class);

        if (!infoResponse.isSuccess()) {
            throw new ApiException(ApiErrorParser.parseCommonError(infoResponse.getError().getCode()));
        }

        return infoResponse.getData().getApiList();
    }

    /**
     * Provides all supported Apis. The request is executed Asynchronous.
     *
     * @param responseCallback provides either an Api list or an exception
     */
    public void apiInfo(AsyncCallback<List<ApiDesc>> responseCallback) {
        String uri = uriAdapter.getUri(INFO_CGI, INFO_API,
                INFO_VERSION, INFO_METHOD,
                Map.of(INFO_PARAM_QUERY, INFO_PARAM_QUERY_VALUE));
        httpClient.executeRequestAsync(uri, InfoResponse.class,
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
        String uri = uriAdapter.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGIN_VERSION, AUTH_LOGIN_METHOD,
                Map.of(AUTH_PARAM_ACCOUNT, account,
                        AUTH_PARAM_PASSWD, passwd,
                        AUTH_PARAM_SESSION, session,
                        AUTH_PARAM_FORMAT, AUTH_PARAM_FORMAT_VALUE));
        LoginResponse loginResponse = httpClient.executeRequest(uri, LoginResponse.class);

        if (!loginResponse.isSuccess()) {
            int errorCode = loginResponse.getError().getCode();
            String desc = ApiErrorParser.isCommonError(errorCode) ?
                    ApiErrorParser.parseCommonError(errorCode) : ApiErrorParser.parseAuthError(errorCode);
            throw new ApiException(desc);
        }

        return loginResponse.getData().getSid();
    }

    /**
     * Login into a {@code session}. The request is executed Asynchronous.
     *
     * @param account  account name
     * @param passwd   account password
     * @param session  session name
     * @param callback provides either a session id or an exception
     */
    public void login(String account, String passwd, String session, AsyncCallback<String> callback) {
        String uri = uriAdapter.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGIN_VERSION, AUTH_LOGIN_METHOD,
                Map.of(AUTH_PARAM_ACCOUNT, account,
                        AUTH_PARAM_PASSWD, passwd,
                        AUTH_PARAM_SESSION, session,
                        AUTH_PARAM_FORMAT, AUTH_PARAM_FORMAT_VALUE));
        httpClient.executeRequestAsync(uri, LoginResponse.class,
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
        String uri = uriAdapter.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGOUT_VERSION, AUTH_LOGOUT_METHOD,
                Map.of(AUTH_PARAM_SESSION, session));
        LogoutResponse logoutResponse = httpClient.executeRequest(uri, LogoutResponse.class);

        if (!logoutResponse.isSuccess()) {
            int errorCode = logoutResponse.getError().getCode();
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
    public void logout(String session, AsyncCallback<Void> callback) {
        String uri = uriAdapter.getUri(AUTH_CGI, AUTH_API,
                AUTH_LOGOUT_VERSION, AUTH_LOGOUT_METHOD,
                Map.of(AUTH_PARAM_SESSION, session));
        httpClient.executeRequestAsync(uri, LogoutResponse.class, response -> null, callback);
    }

    public UriAdapter getUriAdapter() {
        return uriAdapter;
    }

    public void setUriAdapter(UriAdapter uriAdapter) {
        this.uriAdapter = uriAdapter;
    }

    public ClientAdapter getClientAdapter() {
        return httpClient;
    }

    public void setClientAdapter(ClientAdapter httpClient) {
        this.httpClient = httpClient;
    }
}
