package webapi.net;

/**
 * Exception contact for {@link HttpClientAdapter}.
 */
public enum ClientErrorContract {

    REQUEST_EXECUTE("An error occurred while executing a http/https request"),
    RESPONSE_NOT_SUCCESSFUL("The http code is not in the interval [200,300)"),
    RESPONSE_RECEIVE("An error occurred while reading the http response"),
    RESPONSE_PARSE("An error occurred while parsing the http response");

    private final String errorDesc;

    ClientErrorContract(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
