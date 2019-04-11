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
import webapi.model.dls.DlsConfig;
import webapi.model.dls.DlsInfo;
import webapi.model.dls.DlsTaskList;
import webapi.net.AsyncCallback;
import webapi.net.ClientException;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Get Api Test
 */
public class GetApiTest {

    /**
     * @param args 0: HOST
     *             1: PORT
     *             2: SSL
     *             3: USER
     *             4: PW
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        String port = (args[1].equals("null") ? null : args[1]);
        WebApi api = new WebApi(args[0], port, Boolean.parseBoolean(args[2]));
        DlsApi dlsApi = api.getDlsApi();

        String sid = null;
        try {
            sid = dlsApi.login(args[3], args[4], ApiContract.DLS_PARAM_SESSION_VALUE);
            System.out.println("_sid:\t" + sid);
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }

        // INFO
        testInfo(dlsApi, sid);

        // CONFIG
        testConfig(dlsApi, sid);

        // LIST
        testList(dlsApi, sid);
    }

    private static void testInfo(DlsApi dlsApi, String sid) {
        DlsInfo dlsInfo = null;
        try {
            dlsInfo = dlsApi.getInfo(sid);
            System.out.println(dlsInfo);
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }

        dlsApi.getInfo(sid, new AsyncCallback<>() {
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
            public void onResponse(DlsInfo response) {
                System.out.println(response + " (Async)");
            }
        });
    }

    private static void testConfig(DlsApi dlsApi, String sid) {
        try {
            DlsConfig dlsConfig = dlsApi.getConfig(sid);
            System.out.println(dlsConfig);
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }

        dlsApi.getConfig(sid, new AsyncCallback<>() {
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
            public void onResponse(DlsConfig response) {
                System.out.println(response + " (Async)");
            }
        });
    }

    private static void testList(DlsApi dlsApi, String sid) {
        try {
            DlsTaskList taskList = dlsApi.getTasks(sid, null, null);
            System.out.println(taskList);
            taskList = dlsApi.getTasks(sid, "1", "2");
            System.out.println(taskList);
        } catch (ClientException e) {
            System.out.println(e.getCode().getDesc());
            e.printStackTrace();
        } catch (ApiException e) {
            System.out.println(e.getDesc());
            e.printStackTrace();
        }

        final String finalSid = sid;
        dlsApi.getTasks(sid, null, null, new AsyncCallback<>() {
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
            public void onResponse(DlsTaskList response) {
                System.out.println(response + " (Async)");
                dlsApi.getTasks(finalSid, "1", "2", new AsyncCallback<>() {
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
                    public void onResponse(DlsTaskList response) {
                        System.out.println(response + " (Async)");
                    }
                });
            }
        });
    }

}
