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
import org.apache.commons.lang3.builder.ToStringStyle;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_manager",
        "version",
        "version_string"
})
/**
 * {@code version}          Build number of Download Station
 * {@code version_string}   Full version string of Download Station
 * {@code isManager}        If the logged in user is manager
 */
public class DlsInfo {

    @JsonProperty("is_manager")
    private boolean isManager;
    @JsonProperty("version")
    private int version;
    @JsonProperty("version_string")
    private String versionString;

    /**
     * No args constructor for use in serialization
     */
    public DlsInfo() {
    }

    /**
     * @param isManager
     * @param version
     * @param versionString
     */
    public DlsInfo(boolean isManager, int version, String versionString) {
        super();
        this.isManager = isManager;
        this.version = version;
        this.versionString = versionString;
    }

    @JsonProperty("is_manager")
    public boolean isIsManager() {
        return isManager;
    }

    @JsonProperty("is_manager")
    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(int version) {
        this.version = version;
    }

    @JsonProperty("version_string")
    public String getVersionString() {
        return versionString;
    }

    @JsonProperty("version_string")
    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("isManager", isManager)
                .append("version", version).append("versionString", versionString).toString();
    }

}
