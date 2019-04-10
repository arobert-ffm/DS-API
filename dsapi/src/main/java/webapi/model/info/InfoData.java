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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = InfoDataDeserializer.class)
public class InfoData {

    private List<ApiDesc> apiList = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public InfoData() {
    }

    public InfoData(List<ApiDesc> apiList) {
        this.apiList = apiList;
    }


    public List<ApiDesc> getApiList() {
        return apiList;
    }

    public void setApiList(List<ApiDesc> apiList) {
        this.apiList = apiList;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apiList", apiList).toString();
    }

}
