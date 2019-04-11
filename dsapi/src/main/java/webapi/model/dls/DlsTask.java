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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DlsTask {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("username")
    private String username;
    @JsonProperty("title")
    private String title;
    @JsonProperty("size")
    private String size;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_extra")
    private DlsTaskStatusDesc statusDesc;
    @JsonProperty("detail")
    private DlsTaskDetails details;
    @JsonProperty("transfer")
    private DlsTaskTransfer transfer;

    /**
     * No args constructor for use in serialization
     */
    public DlsTask() {
    }

    /**
     * @param id
     * @param type
     * @param username
     * @param title
     * @param size
     * @param status
     * @param statusDesc
     * @param details
     * @param transfer
     */
    public DlsTask(String id, String type, String username, String title, String size, String status,
                   DlsTaskStatusDesc statusDesc, DlsTaskDetails details, DlsTaskTransfer transfer) {
        super();
        this.id = id;
        this.type = type;
        this.username = username;
        this.title = title;
        this.size = size;
        this.status = status;
        this.statusDesc = statusDesc;
        this.details = details;
        this.transfer = transfer;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status_extra")
    public DlsTaskStatusDesc getStatusDesc() {
        return statusDesc;
    }

    @JsonProperty("status_extra")
    public void setStatusDesc(DlsTaskStatusDesc statusDesc) {
        this.statusDesc = statusDesc;
    }

    @JsonProperty("detail")
    public DlsTaskDetails getDetails() {
        return details;
    }

    @JsonProperty("detail")
    public void setDetails(DlsTaskDetails details) {
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
        return new ToStringBuilder(this).append("id", id)
                .append("type", type)
                .append("username", username)
                .append("title", title)
                .append("size", size)
                .append("status", status)
                .append("statusDesc", statusDesc)
                .append("detail", details)
                .append("transfer", transfer).toString();
    }

    @JsonCreator
    public static DlsTask create(@JsonProperty("id") String id, @JsonProperty("type") String type,
                                 @JsonProperty("username") String username, @JsonProperty("title") String title,
                                 @JsonProperty("size") String size, @JsonProperty("status") String status,
                                 @JsonProperty("statusDesc") DlsTaskStatusDesc statusDesc,
                                 @JsonProperty("additional") DlsTaskAdditional additional) {
        return new DlsTask(id, type, username, title, size, status, statusDesc,
                additional.getDetail(), additional.getTransfer());
    }
}
