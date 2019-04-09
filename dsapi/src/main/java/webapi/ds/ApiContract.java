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
}
