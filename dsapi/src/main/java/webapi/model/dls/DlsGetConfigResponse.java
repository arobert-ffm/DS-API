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

package webapi.model.dls;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import webapi.model.ApiError;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "error",
        "success"
})
public class DlsGetConfigResponse {

    @JsonProperty("data")
    private DlsConfig data;
    @JsonProperty("error")
    private ApiError error;
    @JsonProperty("success")
    private boolean success;

    /**
     * No args constructor for use in serialization
     */
    public DlsGetConfigResponse() {
    }

    /**
     * @param data
     * @param error
     * @param success
     */
    public DlsGetConfigResponse(DlsConfig data, ApiError error, boolean success) {
        super();
        this.data = data;
        this.error = error;
        this.success = success;
    }

    @JsonProperty("data")
    public DlsConfig getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(DlsConfig data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("error", error)
                .append("success", success).toString();
    }

}
