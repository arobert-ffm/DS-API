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

package webapi.net;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UriAdapterTest {

    private String IP = "192.167.178.80";
    private String cgiPath = "myCgi";
    private String apiName = "myApiNAme";
    private String version = "myVersion";
    private String method = "myMethod";
    private String sid = "mySid";
    private Map<String, String> params = Map.of("TestParam", "TestValue");

    @Test
    void constructorSslTest() {
        // HTTP
        UriAdapter uriAdapter = new UriAdapter(IP, null, false);
        assertFalse(uriAdapter.isSsl());

        String uri = uriAdapter.getUri("", "", "", "");
        assertTrue(uri.startsWith("http"));

        // HTTPS
        uriAdapter = new UriAdapter(IP, null, true);
        assertTrue(uriAdapter.isSsl());

        uri = uriAdapter.getUri("", "", "", "");
        assertTrue(uri.startsWith("https"));
    }

    @Test
    void constructorPortTest() {
        // Custom Port
        UriAdapter uriAdapter = new UriAdapter(IP, "4444", false);
        assertEquals("4444", uriAdapter.getPort());

        // Default http Port
        uriAdapter = new UriAdapter(IP, null, false);
        assertEquals("5000", uriAdapter.getPort());

        // Default https Port
        uriAdapter = new UriAdapter(IP, null, true);
        assertEquals("5001", uriAdapter.getPort());
    }

    @Test
    void getUriWithoutSidParams() {
        String outputUri = "http://192.167.178.80:5000/webapi/myCgi?api=myApiNAme&version=myVersion&method=myMethod";
        UriAdapter uriAdapter = new UriAdapter(IP, null, false);
        String uri = uriAdapter.getUri(cgiPath, apiName, version, method);
        assertEquals(outputUri, uri);
    }

    @Test
    void getUriWithoutParams() {
        String outputUri = "http://192.167.178.80:5000/webapi/myCgi?api=myApiNAme&version=myVersion&method=myMethod&_sid=mySid";
        UriAdapter uriAdapter = new UriAdapter(IP, null, false);
        String uri = uriAdapter.getUri(cgiPath, apiName, version, method, sid);
        assertEquals(outputUri, uri);
    }

    @Test
    void getUriWithoutSid() {
        String outputUri = "http://192.167.178.80:5000/webapi/myCgi?api=myApiNAme&version=myVersion&method=myMethod&TestParam=TestValue";
        UriAdapter uriAdapter = new UriAdapter(IP, null, false);
        String uri = uriAdapter.getUri(cgiPath, apiName, version, method, params);
        assertEquals(outputUri, uri);
    }

    @Test
    void getUri() {
        String outputUri = "http://192.167.178.80:5000/webapi/myCgi?api=myApiNAme&version=myVersion&method=myMethod&_sid=mySid&TestParam=TestValue";
        UriAdapter uriAdapter = new UriAdapter(IP, null, false);
        String uri = uriAdapter.getUri(cgiPath, apiName, version, method, sid, params);
        assertEquals(outputUri, uri);
    }

}