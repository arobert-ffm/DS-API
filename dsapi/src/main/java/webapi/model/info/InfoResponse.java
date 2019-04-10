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

package webapi.model.info;

import org.apache.commons.lang3.builder.ToStringBuilder;
import webapi.model.ApiError;


public class InfoResponse {

    private InfoData data;
    private ApiError error;
    private boolean success;

    /**
     * No args constructor for use in serialization
     */
    public InfoResponse() {
    }

    /**
     * @param error
     * @param data
     * @param success
     */
    public InfoResponse(InfoData data, ApiError error, boolean success) {
        super();
        this.data = data;
        this.error = error;
        this.success = success;
    }

    public InfoData getData() {
        return data;
    }

    public void setData(InfoData data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("error", error)
                .append("success", success).toString();
    }

}
