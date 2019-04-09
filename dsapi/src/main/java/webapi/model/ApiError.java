package webapi.model;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class ApiError {

    private int code;

    /**
     * No args constructor for use in serialization
     */
    public ApiError() {
    }

    /**
     * @param code
     */
    public ApiError(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).toString();
    }

}
