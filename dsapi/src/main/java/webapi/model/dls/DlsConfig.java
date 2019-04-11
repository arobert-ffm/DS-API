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
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * {@code default_destination}          Default destination
 * {@code bt_max_download}              Max BT download speed in KB/s (“0” means unlimited)
 * {@code bt_max_upload}                Max BT upload speed in KB/s (“0” means unlimited)
 * {@code emule_enabled}                If eMule service is enabled
 * {@code emule_default_destination}    Emule default destination
 * {@code emule_max_download}           Max eMule download speed in KB/s (“0” means unlimited)
 * {@code emule_max_upload}             Max eMule upload speed in KB/s (“0” means unlimited)
 * {@code ftp_max_download}             Max FTP download speed in KB/s (“0” means unlimited).
 *                                      For more info, please see Limitations below.
 * {@code http_max_download}            Max HTTP download speed in KB/s (“0” means unlimited).
 *                                      For more info, please see Limitations below.
 * {@code nzb_max_download}             Max NZB download speed in KB/s (“0” means unlimited)
 * {@code unzip_service_enabled}        If Auto unzip service is enabled for users except admin or administrators group
 *
 * Limitations:
 * 1. Currently http_max_download and ftp_max_download share the same config value. When
 * both parameters are requested to be set at the same time, the requested ftp_max_download rate
 * will overwrite the requested http_max_download rate.
 *
 * 2. Considering identical rates may be simultaneously used by the other packages other than
 * Download Station, the HTTP and FTP max download rates will not affect tasks whose current status
 * is “downloading”. New rates will only be applied to those newly added/resumed HTTP/FTP tasks.
 */
public class DlsConfig {

    @JsonProperty("default_destination")
    private String defaultDestination;
    @JsonProperty("bt_max_download")
    private String btMaxDownload;
    @JsonProperty("bt_max_upload")
    private String btMaxUpload;
    @JsonProperty("emule_enabled")
    private boolean emuleEnabled;
    @JsonProperty("emule_default_destination")
    private String emuleDefaultDestination;
    @JsonProperty("emule_max_download")
    private String emuleMaxDownload;
    @JsonProperty("emule_max_upload")
    private String emuleMaxUpload;
    @JsonProperty("ftp_max_download")
    private String ftpMaxDownload;
    @JsonProperty("http_max_download")
    private String httpMaxDownload;
    @JsonProperty("nzb_max_download")
    private String nzbMaxDownload;
    @JsonProperty("unzip_service_enabled")
    private boolean unzipServiceEnabled;

    /**
     * No args constructor for use in serialization
     */
    public DlsConfig() {
    }

    /**
     * @param defaultDestination
     * @param btMaxDownload
     * @param btMaxUpload
     * @param emuleEnabled
     * @param emuleDefaultDestination
     * @param emuleMaxDownload
     * @param emuleMaxUpload
     * @param ftpMaxDownload
     * @param httpMaxDownload
     * @param nzbMaxDownload
     * @param unzipServiceEnabled
     */
    public DlsConfig(String defaultDestination, String btMaxDownload, String btMaxUpload, boolean emuleEnabled,
                     String emuleDefaultDestination, String emuleMaxDownload, String emuleMaxUpload,
                     String ftpMaxDownload, String httpMaxDownload, String nzbMaxDownload,
                     boolean unzipServiceEnabled) {
        super();
        this.btMaxDownload = btMaxDownload;
        this.btMaxUpload = btMaxUpload;
        this.defaultDestination = defaultDestination;
        this.emuleDefaultDestination = emuleDefaultDestination;
        this.emuleEnabled = emuleEnabled;
        this.emuleMaxDownload = emuleMaxDownload;
        this.emuleMaxUpload = emuleMaxUpload;
        this.ftpMaxDownload = ftpMaxDownload;
        this.httpMaxDownload = httpMaxDownload;
        this.nzbMaxDownload = nzbMaxDownload;
        this.unzipServiceEnabled = unzipServiceEnabled;
    }

    @JsonProperty("default_destination")
    public String getDefaultDestination() {
        return defaultDestination;
    }

    @JsonProperty("default_destination")
    public void setDefaultDestination(String defaultDestination) {
        this.defaultDestination = defaultDestination;
    }

    @JsonProperty("bt_max_download")
    public String getBtMaxDownload() {
        return btMaxDownload;
    }

    @JsonProperty("bt_max_download")
    public void setBtMaxDownload(String btMaxDownload) {
        this.btMaxDownload = btMaxDownload;
    }

    @JsonProperty("bt_max_upload")
    public String getBtMaxUpload() {
        return btMaxUpload;
    }

    @JsonProperty("bt_max_upload")
    public void setBtMaxUpload(String btMaxUpload) {
        this.btMaxUpload = btMaxUpload;
    }

    @JsonProperty("emule_enabled")
    public boolean isEmuleEnabled() {
        return emuleEnabled;
    }

    @JsonProperty("emule_enabled")
    public void setEmuleEnabled(boolean emuleEnabled) {
        this.emuleEnabled = emuleEnabled;
    }

    @JsonProperty("emule_default_destination")
    public String getEmuleDefaultDestination() {
        return emuleDefaultDestination;
    }

    @JsonProperty("emule_default_destination")
    public void setEmuleDefaultDestination(String emuleDefaultDestination) {
        this.emuleDefaultDestination = emuleDefaultDestination;
    }

    @JsonProperty("emule_max_download")
    public String getEmuleMaxDownload() {
        return emuleMaxDownload;
    }

    @JsonProperty("emule_max_download")
    public void setEmuleMaxDownload(String emuleMaxDownload) {
        this.emuleMaxDownload = emuleMaxDownload;
    }

    @JsonProperty("emule_max_upload")
    public String getEmuleMaxUpload() {
        return emuleMaxUpload;
    }

    @JsonProperty("emule_max_upload")
    public void setEmuleMaxUpload(String emuleMaxUpload) {
        this.emuleMaxUpload = emuleMaxUpload;
    }

    @JsonProperty("ftp_max_download")
    public String getFtpMaxDownload() {
        return ftpMaxDownload;
    }

    @JsonProperty("ftp_max_download")
    public void setFtpMaxDownload(String ftpMaxDownload) {
        this.ftpMaxDownload = ftpMaxDownload;
    }

    @JsonProperty("http_max_download")
    public String getHttpMaxDownload() {
        return httpMaxDownload;
    }

    @JsonProperty("http_max_download")
    public void setHttpMaxDownload(String httpMaxDownload) {
        this.httpMaxDownload = httpMaxDownload;
    }

    @JsonProperty("nzb_max_download")
    public String getNzbMaxDownload() {
        return nzbMaxDownload;
    }

    @JsonProperty("nzb_max_download")
    public void setNzbMaxDownload(String nzbMaxDownload) {
        this.nzbMaxDownload = nzbMaxDownload;
    }

    @JsonProperty("unzip_service_enabled")
    public boolean isUnzipServiceEnabled() {
        return unzipServiceEnabled;
    }

    @JsonProperty("unzip_service_enabled")
    public void setUnzipServiceEnabled(boolean unzipServiceEnabled) {
        this.unzipServiceEnabled = unzipServiceEnabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("defaultDestination", defaultDestination)
                .append("btMaxDownload", btMaxDownload)
                .append("btMaxUpload", btMaxUpload)
                .append("emuleEnabled", emuleEnabled)
                .append("emuleDefaultDestination", emuleDefaultDestination)
                .append("emuleMaxDownload", emuleMaxDownload)
                .append("emuleMaxUpload", emuleMaxUpload)
                .append("ftpMaxDownload", ftpMaxDownload)
                .append("httpMaxDownload", httpMaxDownload)
                .append("nzbMaxDownload", nzbMaxDownload)
                .append("unzipServiceEnabled", unzipServiceEnabled).toString();
    }

}
