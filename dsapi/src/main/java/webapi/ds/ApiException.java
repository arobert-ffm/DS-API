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
