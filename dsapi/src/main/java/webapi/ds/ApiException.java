package webapi.ds;

/**
 * Provides information about a Web Api related error. The {@code desc} contains the error description.
 */
public final class ApiException extends Exception {

    private static final long serialVersionUID = 1433624187843386916L;
    private final String desc;

    public ApiException(String desc) {
        super();
        this.desc = desc;
    }

    public ApiException(String message, String desc) {
        super(message);
        this.desc = desc;
    }

    public ApiException(String message, Throwable cause, String desc) {
        super(message, cause);
        this.desc = desc;
    }

    public ApiException(Throwable cause, String desc) {
        super(cause);
        this.desc = desc;
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                        String desc) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
