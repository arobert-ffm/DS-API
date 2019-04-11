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

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * {@code total}    Total number of records
 * {@code offset}   Requests offset
 * {@code tasks}    DlsTask list
 */
public class DlsTaskList {

    @JsonProperty("total")
    private int total;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("tasks")
    private List<DlsTask> tasks = null;


    /**
     * No args constructor for use in serialization
     */
    public DlsTaskList() {
    }

    /**
     * @param total  Total number of records
     * @param tasks  DlsTask list
     * @param offset Requests offset
     */
    public DlsTaskList(int total, int offset, List<DlsTask> tasks) {
        super();
        this.total = total;
        this.offset = offset;
        this.tasks = tasks;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    @JsonProperty("offset")
    public int getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @JsonProperty("tasks")
    public List<DlsTask> getTasks() {
        return tasks;
    }

    @JsonProperty("tasks")
    public void setTasks(List<DlsTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("total", total)
                .append("offset", offset).append("tasks", tasks).toString();
    }

}
