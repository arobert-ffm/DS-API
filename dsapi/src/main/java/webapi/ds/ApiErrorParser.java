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

import java.util.Map;

/**
 * Lookup the description of the Web Api error codes.
 */
public final class ApiErrorParser {

    private static final String error = "%d: %s";

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
        String desc = commonError.get(code);
        return desc == null ? null : String.format(error, code, desc);
    }

    /**
     * The description to the specified code, or {@code null}.
     *
     * @param code Error code
     * @return Description or {@code null}
     */
    public static String parseAuthError(int code) {
        String desc = authError.get(code);
        return desc == null ? null : String.format(error, code, desc);
    }
}
