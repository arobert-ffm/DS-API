package webapi.model.info;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class DsApi {

    private String name;
    private int maxVersion;
    private int minVersion;
    private String path;
    private String requestFormat;

    /**
     * No args constructor for use in serialization
     */
    public DsApi() {
    }

    /**
     * @param name
     * @param maxVersion
     * @param minVersion
     * @param path
     * @param requestFormat
     */
    public DsApi(String name, int maxVersion, int minVersion, String path, String requestFormat) {
        super();
        this.name = name;
        this.maxVersion = maxVersion;
        this.minVersion = minVersion;
        this.path = path;
        this.requestFormat = requestFormat;
    }

    /**
     * @param maxVersion
     * @param path
     * @param minVersion
     */
    public DsApi(String name, int maxVersion, int minVersion, String path) {
        this(name, maxVersion, minVersion, path, null);
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
