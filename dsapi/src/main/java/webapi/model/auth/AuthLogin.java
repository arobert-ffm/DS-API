package webapi.model.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;
import webapi.model.ApiError;


public class AuthLogin {

    private LoginData data;
    private ApiError error;
    private boolean success;

    /**
     * No args constructor for use in serialization
     */
    public AuthLogin() {
    }

    /**
     * @param data
     * @param success
     */
    public AuthLogin(LoginData data, ApiError error, boolean success) {
        super();
        this.data = data;
        this.error = error;
        this.success = success;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
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
        return new ToStringBuilder(this).append("data", data)
                .append("error", error)
                .append("success", success).toString();
    }

}
