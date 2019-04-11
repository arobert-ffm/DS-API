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
        "downloaded_pieces",
        "size_downloaded",
        "size_uploaded",
        "speed_download",
        "speed_upload"
})
public class DlsTaskTransfer {

    @JsonProperty("downloaded_pieces")
    private String downloadedPieces;
    @JsonProperty("size_downloaded")
    private String sizeDownloaded;
    @JsonProperty("size_uploaded")
    private String sizeUploaded;
    @JsonProperty("speed_download")
    private String speedDownload;
    @JsonProperty("speed_upload")
    private String speedUpload;

    /**
     * No args constructor for use in serialization
     */
    public DlsTaskTransfer() {
    }

    /**
     * @param downloadedPieces
     * @param speedUpload
     * @param sizeUploaded
     * @param sizeDownloaded
     * @param speedDownload
     */
    public DlsTaskTransfer(String downloadedPieces, String sizeDownloaded, String sizeUploaded,
                           String speedDownload, String speedUpload) {
        super();
        this.downloadedPieces = downloadedPieces;
        this.sizeDownloaded = sizeDownloaded;
        this.sizeUploaded = sizeUploaded;
        this.speedDownload = speedDownload;
        this.speedUpload = speedUpload;
    }

    @JsonProperty("downloaded_pieces")
    public String getDownloadedPieces() {
        return downloadedPieces;
    }

    @JsonProperty("downloaded_pieces")
    public void setDownloadedPieces(String downloadedPieces) {
        this.downloadedPieces = downloadedPieces;
    }

    @JsonProperty("size_downloaded")
    public String getSizeDownloaded() {
        return sizeDownloaded;
    }

    @JsonProperty("size_downloaded")
    public void setSizeDownloaded(String sizeDownloaded) {
        this.sizeDownloaded = sizeDownloaded;
    }

    @JsonProperty("size_uploaded")
    public String getSizeUploaded() {
        return sizeUploaded;
    }

    @JsonProperty("size_uploaded")
    public void setSizeUploaded(String sizeUploaded) {
        this.sizeUploaded = sizeUploaded;
    }

    @JsonProperty("speed_download")
    public String getSpeedDownload() {
        return speedDownload;
    }

    @JsonProperty("speed_download")
    public void setSpeedDownload(String speedDownload) {
        this.speedDownload = speedDownload;
    }

    @JsonProperty("speed_upload")
    public String getSpeedUpload() {
        return speedUpload;
    }

    @JsonProperty("speed_upload")
    public void setSpeedUpload(String speedUpload) {
        this.speedUpload = speedUpload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("downloadedPieces", downloadedPieces)
                .append("sizeDownloaded", sizeDownloaded)
                .append("sizeUploaded", sizeUploaded)
                .append("speedDownload", speedDownload)
                .append("speedUpload", speedUpload).toString();
    }

}
