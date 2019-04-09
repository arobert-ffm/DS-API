package webapi.ds;

import java.util.Map;

/**
 * Lookup the description of the Web Api error codes.
 */
public final class ApiErrorParser {

    private static final Map<Integer, String> commonError = Map.of(
            100, "Unknown error",
            101, "Invalid parameter",
            102, "The requested API does not exist",
            103, "The requested method does not exist",
            104, "The requested version does not support the functionality",
            105, "The logged in session does not have permission",
            106, "Session timeout",
            107, "Session interrupted by duplicate login");

    private static final Map<Integer, String> authError = Map.of(
            400, "No such account or incorrect password",
            401, "Account disabled",
            402, "Permission denied",
            403, "2-step verification code required",
            404, "Failed to authenticate 2-step verification code");

    /**
     * Checks if the {@code code} is a common error.
     *
     * @param code Error code
     * @return True if a common error, False otherwise
     */
    public static boolean isCommonError(int code) {
        return commonError.containsKey(code);
    }

    /**
     * The description to the specified code, or {@code null}.
     *
     * @param code Error code
     * @return Description or {@code null}
     */
    public static String parseCommonError(int code) {
        return commonError.get(code);
    }

    /**
     * The description to the specified code, or {@code null}.
     *
     * @param code Error code
     * @return Description or {@code null}
     */
    public static String parseAuthError(int code) {
        return authError.get(code);
    }
}
