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

import webapi.DlsApi;
import webapi.WebApi;
import webapi.ds.ApiContract;
import webapi.ds.ApiException;
import webapi.model.info.ApiDesc;
import webapi.net.AsyncCallback;
import webapi.net.ClientException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Base WebApi Test
 */
public class BaseApiTest {

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
        DlsApi dlsApi = api.getDlsApi();

        // INFO
        try {
            List<ApiDesc> apiList = dlsApi.apiInfo();
            System.out.println("Api count:\t" + apiList.size());
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }
        dlsApi.apiInfo(new AsyncCallback<>() {
            @Override
            public void onFailure(Exception e) {
                if (e instanceof ClientException) {
                    System.out.println(((ClientException) e).getCode().getDesc());
                } else if (e instanceof ApiException) {
                    System.out.println(((ApiException) e).getDesc());
                }
                e.printStackTrace();
            }

            @Override
            public void onResponse(List<ApiDesc> response) {
                System.out.println("Api count:\t" + response.size() + " (Async)");
            }
        });

        // LOGIN & LOGOUT
        try {
            String sid = dlsApi.login(args[3], args[4], ApiContract.DLS_PARAM_SESSION_VALUE);
            System.out.println("_sid:\t" + sid);
            boolean logout = dlsApi.logout(ApiContract.DLS_PARAM_SESSION_VALUE);
            System.out.println("Logout successful:\t" + logout);
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }
        dlsApi.login(args[3], args[4], ApiContract.DLS_PARAM_SESSION_VALUE, new AsyncCallback<>() {
            @Override
            public void onFailure(Exception e) {
                if (e instanceof ClientException) {
                    System.out.println(((ClientException) e).getCode().getDesc());
                } else if (e instanceof ApiException) {
                    System.out.println(((ApiException) e).getDesc());
                }
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response) {
                System.out.println("_sid:\t" + response + " (Async)");
                dlsApi.logout(ApiContract.DLS_PARAM_SESSION_VALUE, new AsyncCallback<>() {
                    @Override
                    public void onFailure(Exception e) {
                        if (e instanceof ClientException) {
                            System.out.println(((ClientException) e).getCode().getDesc());
                        } else if (e instanceof ApiException) {
                            System.out.println(((ApiException) e).getDesc());
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Void response) {
                        System.out.println("Logout successful! (Async)");
                    }
                });
            }
        });

//        api.getDlsApi().getHttpClient().close();
    }

}
