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

import webapi.ds.ApiErrorParser;
import webapi.ds.ApiException;
import webapi.ds.BaseApi;
import webapi.model.dls.*;
import webapi.net.AsyncCallback;
import webapi.net.ClientAdapter;
import webapi.net.ClientException;
import webapi.net.UriAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface to access the Download Station Api.
 */
public final class DlsApi extends BaseApi {

    public DlsApi(UriAdapter uriAdapter, ClientAdapter httpClient) {
        super(uriAdapter, httpClient);
    }

    /**
     * Provides information about the Download Station.
     *
     * @param sid session id
     * @return info
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public DlsInfo getInfo(String sid) throws ClientException, ApiException {
        String uri = getUriAdapter().getUri(DLS_INFO_CGI, DLS_INFO_API,
                DLS_INFO_VERSION, DLS_INFO_METHOD_INFO, sid);
        DlsInfoResponse response = getClientAdapter().executeRequest(uri, DlsInfoResponse.class);

        if (!response.isSuccess()) {
            throw new ApiException(ApiErrorParser.parseCommonError(response.getError().getCode()));
        }

        return response.getData();
    }

    /**
     * Provides information about the Download Station. The request is executed Asynchronous.
     *
     * @param sid              session id
     * @param responseCallback provides either the info or an exception
     */
    public void getInfo(String sid, AsyncCallback<DlsInfo> responseCallback) {
        String uri = getUriAdapter().getUri(DLS_INFO_CGI, DLS_INFO_API,
                DLS_INFO_VERSION, DLS_INFO_METHOD_INFO, sid);
        getClientAdapter().executeRequestAsync(uri, DlsInfoResponse.class,
                DlsInfoResponse::getData, responseCallback);
    }

    /**
     * Provides the settings of the Download Station.
     *
     * @param sid session id
     * @return settings
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public DlsConfig getConfig(String sid) throws ClientException, ApiException {
        String uri = getUriAdapter().getUri(DLS_INFO_CGI, DLS_INFO_API,
                DLS_INFO_VERSION, DLS_INFO_METHOD_GETCONFIG, sid);
        DlsGetConfigResponse response = getClientAdapter().executeRequest(uri, DlsGetConfigResponse.class);

        if (!response.isSuccess()) {
            throw new ApiException(ApiErrorParser.parseCommonError(response.getError().getCode()));
        }

        return response.getData();
    }

    /**
     * Provides the settings of the Download Station. The request is executed Asynchronous.
     *
     * @param sid              session id
     * @param responseCallback provides either the settings or an exception
     */
    public void getConfig(String sid, AsyncCallback<DlsConfig> responseCallback) {
        String uri = getUriAdapter().getUri(DLS_INFO_CGI, DLS_INFO_API,
                DLS_INFO_VERSION, DLS_INFO_METHOD_GETCONFIG, sid);
        getClientAdapter().executeRequestAsync(uri, DlsGetConfigResponse.class,
                DlsGetConfigResponse::getData, responseCallback);
    }

    /**
     * Provides a task list and detailed task information.
     *
     * @param sid    session id
     * @param offset (Optional) beginning task on the requested record (e.g. "5"). Default is no offset.
     * @param limit  (Optional) number of records requested (e.g. "10"). Default is all records.
     * @return list of tasks
     * @throws ClientException when an error occurred while accessing the DiskStation
     * @throws ApiException    is thrown when the request was not successful
     */
    public DlsTaskList getTasks(String sid, String offset, String limit) throws ClientException, ApiException {
        Map<String, String> params = new HashMap<>();
        params.put(DLS_TASK_PARAM_ADDITIONAL, DLS_TASK_PARAM_ADDITIONAL_VALUE);
        if (offset != null) {
            params.put(DLS_TASK_PARAM_OFFSET, offset);
        }
        if (limit != null) {
            params.put(DLS_TASK_PARAM_LIMIT, limit);
        }

        String uri = getUriAdapter().getUri(DLS_TASK_CGI, DLS_TASK_API,
                DLS_TASK_VERSION, DLS_TASK_METHOD, sid, params);
        DlsTaskListResponse response = getClientAdapter().executeRequest(uri, DlsTaskListResponse.class);

        if (!response.isSuccess()) {
            throw new ApiException(ApiErrorParser.parseCommonError(response.getError().getCode()));
        }

        return response.getData();
    }

    /**
     * Provides a task list and detailed task information. The request is executed Asynchronous.
     *
     * @param sid              session id
     * @param offset           (Optional) beginning task on the requested record (e.g. "5"). Default is no offset.
     * @param limit            (Optional) number of records requested (e.g. "10"). Default is all records.
     * @param responseCallback provides either a list of tasks or an exception
     */
    public void getTasks(String sid, String offset, String limit, AsyncCallback<DlsTaskList> responseCallback) {
        Map<String, String> params = new HashMap<>();
        params.put(DLS_TASK_PARAM_ADDITIONAL, DLS_TASK_PARAM_ADDITIONAL_VALUE);
        if (offset != null) {
            params.put(DLS_TASK_PARAM_OFFSET, offset);
        }
        if (limit != null) {
            params.put(DLS_TASK_PARAM_LIMIT, limit);
        }

        String uri = getUriAdapter().getUri(DLS_TASK_CGI, DLS_TASK_API,
                DLS_TASK_VERSION, DLS_TASK_METHOD, sid, params);
        getClientAdapter().executeRequestAsync(uri, DlsTaskListResponse.class,
                DlsTaskListResponse::getData, responseCallback);
    }
}
