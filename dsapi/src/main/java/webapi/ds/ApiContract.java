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

/**
 * Contract for the DiskStation Web Api.
 */
public interface ApiContract {

    // INFO
    String INFO_API = "SYNO.API.Info";
    String INFO_CGI = "query.cgi";
    String INFO_VERSION = "1";
    String INFO_METHOD = "query";
    String INFO_PARAM_QUERY = "query";
    String INFO_PARAM_QUERY_VALUE = "all";

    // AUTH
    String AUTH_API = "SYNO.API.Auth";
    String AUTH_CGI = "auth.cgi";
    String AUTH_LOGIN_VERSION = "2";
    String AUTH_LOGIN_METHOD = "login";
    String AUTH_LOGOUT_VERSION = "1";
    String AUTH_LOGOUT_METHOD = "logout";
    String AUTH_PARAM_ACCOUNT = "account";
    String AUTH_PARAM_PASSWD = "passwd";
    String AUTH_PARAM_SESSION = "session";
    String AUTH_PARAM_FORMAT = "format";
    String AUTH_PARAM_FORMAT_VALUE = "sid";

    // DownloadStation
    String DLS_PARAM_SESSION_VALUE = "DownloadStation";

    // DownloadStation Info
    String DLS_INFO_CGI = "DownloadStation/info.cgi";
    String DLS_INFO_API = "SYNO.DownloadStation.Info";
    String DLS_INFO_VERSION = "1";
    String DLS_INFO_METHOD_INFO = "getinfo";
    String DLS_INFO_METHOD_GETCONFIG = "getconfig";

    // DownloadStation DlsTask
    String DLS_TASK_CGI = "DownloadStation/task.cgi";
    String DLS_TASK_API = "SYNO.DownloadStation.Task";
    String DLS_TASK_VERSION = "1";
    String DLS_TASK_METHOD = "list";
    String DLS_TASK_PARAM_OFFSET = "offset";
    String DLS_TASK_PARAM_LIMIT = "limit";
    String DLS_TASK_PARAM_ADDITIONAL = "additional";
    String DLS_TASK_PARAM_ADDITIONAL_VALUE = "detail,transfer";
}
