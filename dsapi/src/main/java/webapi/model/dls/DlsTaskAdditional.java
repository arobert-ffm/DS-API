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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "detail",
        "transfer"
})
public class DlsTaskAdditional {

    @JsonProperty("detail")
    private DlsTaskDetails details;
    @JsonProperty("transfer")
    private DlsTaskTransfer transfer;

    /**
     * No args constructor for use in serialization
     */
    public DlsTaskAdditional() {
    }

    /**
     * @param transfer
     * @param details
     */
    public DlsTaskAdditional(DlsTaskDetails details, DlsTaskTransfer transfer) {
        super();
        this.details = details;
        this.transfer = transfer;
    }

    @JsonProperty("detail")
    public DlsTaskDetails getDetail() {
        return details;
    }

    @JsonProperty("detail")
    public void setDetail(DlsTaskDetails details) {
        this.details = details;
    }

    @JsonProperty("transfer")
    public DlsTaskTransfer getTransfer() {
        return transfer;
    }

    @JsonProperty("transfer")
    public void setTransfer(DlsTaskTransfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("detail", details)
                .append("transfer", transfer).toString();
    }

}
