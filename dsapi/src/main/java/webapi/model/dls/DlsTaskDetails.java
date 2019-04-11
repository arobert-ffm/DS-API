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
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DlsTaskDetails {

    @JsonProperty("completed_time")
    private String completedTime;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("started_time")
    private String startedTime;
    @JsonProperty("total_pieces")
    private int totalPieces;
    @JsonProperty("unzip_password")
    private String unzipPassword;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("waiting_seconds")
    private String waitingSeconds;

    /**
     * No args constructor for use in serialization
     */
    public DlsTaskDetails() {
    }

    /**
     * @param createTime
     * @param completedTime
     * @param unzipPassword
     * @param totalPieces
     * @param waitingSeconds
     * @param uri
     * @param startedTime
     * @param destination
     */
    public DlsTaskDetails(String completedTime, String createTime, String destination, String startedTime, int totalPieces,
                          String unzipPassword, String uri, String waitingSeconds) {
        super();
        this.completedTime = completedTime;
        this.createTime = createTime;
        this.destination = destination;
        this.startedTime = startedTime;
        this.totalPieces = totalPieces;
        this.unzipPassword = unzipPassword;
        this.uri = uri;
        this.waitingSeconds = waitingSeconds;
    }

    @JsonProperty("completed_time")
    public String getCompletedTime() {
        return completedTime;
    }

    @JsonProperty("completed_time")
    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    @JsonProperty("create_time")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("started_time")
    public String getStartedTime() {
        return startedTime;
    }

    @JsonProperty("started_time")
    public void setStartedTime(String startedTime) {
        this.startedTime = startedTime;
    }

    @JsonProperty("total_pieces")
    public int getTotalPieces() {
        return totalPieces;
    }

    @JsonProperty("total_pieces")
    public void setTotalPieces(int totalPieces) {
        this.totalPieces = totalPieces;
    }

    @JsonProperty("unzip_password")
    public String getUnzipPassword() {
        return unzipPassword;
    }

    @JsonProperty("unzip_password")
    public void setUnzipPassword(String unzipPassword) {
        this.unzipPassword = unzipPassword;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("waiting_seconds")
    public String getWaitingSeconds() {
        return waitingSeconds;
    }

    @JsonProperty("waiting_seconds")
    public void setWaitingSeconds(String waitingSeconds) {
        this.waitingSeconds = waitingSeconds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("completedTime", completedTime)
                .append("createTime", createTime)
                .append("destination", destination)
                .append("startedTime", startedTime)
                .append("totalPieces", totalPieces)
                .append("unzipPassword", unzipPassword)
                .append("uri", uri)
                .append("waitingSeconds", waitingSeconds).toString();
    }

}
