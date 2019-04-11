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


public class ApiDesc {

    private String name;
    private int maxVersion;
    private int minVersion;
    private String path;
    private String requestFormat;

    /**
     * No args constructor for use in serialization
     */
    public ApiDesc() {
    }

    /**
     * @param name
     * @param maxVersion
     * @param minVersion
     * @param path
     * @param requestFormat
     */
    public ApiDesc(String name, int maxVersion, int minVersion, String path, String requestFormat) {
        super();
        this.name = name;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
        this.path = path;
        this.requestFormat = requestFormat;
    }

    /**
     * @param name
     * @param maxVersion
     * @param minVersion
     * @param path
     */
    public ApiDesc(String name, int maxVersion, int minVersion, String path) {
        this(name, maxVersion, minVersion, path, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(int maxVersion) {
        this.maxVersion = maxVersion;
    }

    public int getMinVersion() {
        return minVersion;
    }

    public void setMinVersion(int minVersion) {
        this.minVersion = minVersion;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRequestFormat() {
        return requestFormat;
    }

    public void setRequestFormat(String requestFormat) {
        this.requestFormat = requestFormat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name)
                .append("maxVersion", maxVersion)
                .append("minVersion", minVersion)
                .append("path", path)
                .append("requestFormat", requestFormat).toString();
    }

}
