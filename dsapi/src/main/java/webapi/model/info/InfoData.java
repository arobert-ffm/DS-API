package webapi.model.info;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = InfoDataDeserializer.class)
public class InfoData {

    private List<DsApi> apiList = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public InfoData() {
    }

    public InfoData(List<DsApi> apiList) {
        this.apiList = apiList;
    }


    public List<DsApi> getApiList() {
        return apiList;
    }

    public void setApiList(List<DsApi> apiList) {
        this.apiList = apiList;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apiList", apiList).toString();
    }

}
