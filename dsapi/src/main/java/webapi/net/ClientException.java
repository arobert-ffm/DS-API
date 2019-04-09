package webapi.net;

/**
 * This Exception wraps all the exceptions inside the {@link HttpClientAdapter} and provides an
 * error code from {@link ClientErrorContract}.
 */
public final class ClientException extends Exception {

    private static final long serialVersionUID = -9027821692891677822L;
    private final ClientErrorContract code;

    public ClientException(ClientErrorContract code) {
        super();
        this.code = code;
    }

    public ClientException(String message, ClientErrorContract code) {
        super(message);
        this.code = code;
    }

    public ClientException(String message, Throwable cause, ClientErrorContract code) {
        super(message, cause);
        this.code = code;
    }

    public ClientException(Throwable cause, ClientErrorContract code) {
        super(cause);
        this.code = code;
    }

    public ClientException(String message, Throwable cause, boolean enableSuppression,
                           boolean writableStackTrace, ClientErrorContract code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public ClientErrorContract getCode() {
        return code;
    }
}
