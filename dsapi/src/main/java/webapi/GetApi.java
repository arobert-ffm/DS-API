package webapi;

import webapi.ds.BaseApi;
import webapi.ds.UriBuilder;
import webapi.net.HttpClientAdapter;

/**
 * Interface to access the Download Station Api.
 */
public final class GetApi extends BaseApi {

    public GetApi(UriBuilder uriBuilder, HttpClientAdapter httpClient) {
        super(uriBuilder, httpClient);
    }

}
