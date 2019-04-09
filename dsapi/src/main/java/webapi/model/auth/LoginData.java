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

package webapi.model.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class LoginData {

    private String sid;

    /**
     * No args constructor for use in serialization
     */
    public LoginData() {
    }

    /**
     * @param sid
     */
    public LoginData(String sid) {
        super();
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sid", sid).toString();
    }

}
