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

package webapi;

import webapi.ds.BaseApi;
import webapi.net.UriAdapter;
import webapi.net.ClientAdapter;

/**
 * Interface to access the Download Station Api.
 */
public final class GetApi extends BaseApi {

    public GetApi(UriAdapter uriAdapter, ClientAdapter httpClient) {
        super(uriAdapter, httpClient);
    }

}
