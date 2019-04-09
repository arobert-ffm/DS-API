package webapi.model.info;

import org.apache.commons.lang3.builder.ToStringBuilder;
import webapi.model.ApiError;


public class ApiInfo {

    private InfoData data;
    private ApiError error;
    private boolean success;

    /**
     * No args constructor for use in serialization
     */
    public ApiInfo() {
    }

    /**
     * @param error
     * @param data
     * @param success
     */
    public ApiInfo(InfoData data, ApiError error, boolean success) {
        super();
        this.data = data;
        this.error = error;
        this.success = success;
    }

    public InfoData getData() {
        return data;
    }

    public void setData(InfoData data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("error", error)
                .append("success", success).toString();
    }

}
