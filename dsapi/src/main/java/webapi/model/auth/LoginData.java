package webapi.model.auth;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class LoginData {

    private String sid;

    /**
     * No args constructor for use in serialization
     */
    public LoginData() {
    }

    /**
     * @param sid
     */
    public LoginData(String sid) {
        super();
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sid", sid).toString();
    }

}
