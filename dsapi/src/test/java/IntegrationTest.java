import webapi.GetApi;
import webapi.WebApi;
import webapi.ds.ApiCallback;
import webapi.ds.ApiContract;
import webapi.ds.ApiException;
import webapi.model.info.DsApi;
import webapi.net.ClientException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * WebApi Test
 */
public final class IntegrationTest {

    /**
     * @param args 0: HOST
     *             1: PORT
     *             2: SSL
     *             3: USER
     *             4: PW
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        String port = (args[1].equals("null") ? null : args[1]);
        WebApi api = new WebApi(args[0], port, Boolean.parseBoolean(args[2]));
        GetApi getApi = api.getGetApi();

        // INFO
        try {
            List<DsApi> apiList = getApi.apiInfo();
            System.out.println("Api count:\t" + apiList.size());
        } catch (ClientException e) {
            System.out.println(e.getCode().getErrorDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }
        getApi.apiInfo(new ApiCallback<>() {
            @Override
            public void onFailure(Exception e) {
                if (e instanceof ClientException) {
                    System.out.println(((ClientException) e).getCode().getErrorDesc());
                } else if (e instanceof ApiException) {
                    System.out.println(((ApiException) e).getDesc());
                }
                e.printStackTrace();
            }

            @Override
            public void onResponse(List<DsApi> response) {
                System.out.println("Api count:\t" + response.size());
            }
        });

        // LOGIN & LOGOUT
        try {
            String sid = getApi.login(args[3], args[4], ApiContract.DLS_PARAM_SESSION_VALUE);
            System.out.println("_sid:\t" + sid);
            boolean logout = getApi.logout(ApiContract.DLS_PARAM_SESSION_VALUE);
            System.out.println("Logout successful:\t" + logout);
        } catch (ClientException e) {
            System.out.println(e.getCode().getErrorDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }
        getApi.login(args[3], args[4], ApiContract.DLS_PARAM_SESSION_VALUE, new ApiCallback<>() {
            @Override
            public void onFailure(Exception e) {
                if (e instanceof ClientException) {
                    System.out.println(((ClientException) e).getCode().getErrorDesc());
                } else if (e instanceof ApiException) {
                    System.out.println(((ApiException) e).getDesc());
                }
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response) {
                System.out.println("_sid:\t" + response);
                getApi.logout(ApiContract.DLS_PARAM_SESSION_VALUE, new ApiCallback<>() {
                    @Override
                    public void onFailure(Exception e) {
                        if (e instanceof ClientException) {
                            System.out.println(((ClientException) e).getCode().getErrorDesc());
                        } else if (e instanceof ApiException) {
                            System.out.println(((ApiException) e).getDesc());
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Void response) {
                        System.out.println("Logout successful!");
                    }
                });
            }
        });

//        api.getGetApi().getHttpClient().close();
    }

}
