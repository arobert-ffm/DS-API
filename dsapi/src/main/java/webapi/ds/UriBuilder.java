package webapi.ds;

import java.net.URI;
import java.util.Map;

/**
 * Generates an uri for an api request. The general syntax is:
 * /webapi/<CGI_PATH>?api=<API_NAME>&version=<VERSION>&method=<METHOD>[&<PARAMS>][&_sid=<SID>]
 * <p>
 * When setting the {@code ssl} parameter, the {@code port} should also be updated.
 */
public final class UriBuilder {

    // Default parameters
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final String PORT_HTTP = "5000";
    private static final String PORT_HTTPS = "5001";

    // Web api get request syntax
    private static final String request = "%s://%s:%s/webapi/%s?api=%s&version=%s&method=%s";
    private static final String requestParam = "&%s=%s";
    private static final String requestSid = "&_sid=%s";

    private String scheme;
    private String host;
    private String port;
    private boolean ssl;

    /**
     * @param host Address of the DiskStation.
     * @param port Port number
     * @param ssl  if true then SSL/TLS encryption is used
     */
    public UriBuilder(String host, String port, boolean ssl) {
        setSsl(ssl);
        setHost(host);
        setPort(port);
    }

    public String getUri(String cgiPath, String apiName, String version, String method) {
        return getUri(cgiPath, apiName, version, method, null, null);
    }

    public String getUri(String cgiPath, String apiName, String version, String method,
                         String sid) {
        return getUri(cgiPath, apiName, version, method, sid, null);
    }

    public String getUri(String cgiPath, String apiName, String version, String method,
                         Map<String, String> params) {
        return getUri(cgiPath, apiName, version, method, null, params);
    }

    public String getUri(String cgiPath, String apiName, String version, String method,
                         String sid, Map<String, String> params) {
        String uriParams = "";
        if (params != null) {
            for (String key : params.keySet()) {
                uriParams += String.format(requestParam, key, params.get(key));
            }
        }

        String uriSid = (sid == null ? "" : String.format(requestSid, sid));

        String uri = URI.create(String.format(request,
                scheme,
                host, port,
                cgiPath, apiName, version, method) +
                uriSid +
                uriParams).toString();

        return uri;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = (port == null ? (ssl ? PORT_HTTPS : PORT_HTTP) : port);
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
        this.scheme = ssl ? SCHEME_HTTPS : SCHEME_HTTP;
    }
}
