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

package webapi.net;

/**
 * Exception contact for {@link ClientAdapter}.
 */
public enum ClientErrorContract {

    REQUEST_EXECUTE("An error occurred while executing a http/https request"),
    RESPONSE_NOT_SUCCESSFUL("The http code is not in the interval [200,300)"),
    RESPONSE_PARSE("An error occurred while parsing the http response");

    private final String errorDesc;

    ClientErrorContract(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
