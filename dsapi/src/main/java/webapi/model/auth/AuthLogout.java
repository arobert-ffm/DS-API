package webapi.model.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;
import webapi.model.ApiError;


public class AuthLogout {

    private ApiError error;
    private boolean success;

    /**
     * No args constructor for use in serialization
     */
    public AuthLogout() {
    }

    /**
     * @param success
     */
    public AuthLogout(ApiError error, boolean success) {
        super();
        this.error = error;
        this.success = success;
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
        return new ToStringBuilder(this).append("error", error)
                .append("success", success).toString();
    }

}
