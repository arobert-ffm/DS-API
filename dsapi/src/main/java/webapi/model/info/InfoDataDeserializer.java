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

package webapi.model.info;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Jackson mapper for {@link InfoData}.
 */
public class InfoDataDeserializer extends StdDeserializer<InfoData> {

    public InfoDataDeserializer() {
        super(InfoData.class);
    }

    @Override
    public InfoData deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = parser.getCodec().readTree(parser);

        List<DsApi> apis = new ArrayList<>();
        DsApi api;

        Iterator<Map.Entry<String, JsonNode>> iterator = node.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            JsonNode objNode = entry.getValue();
            api = new DsApi(entry.getKey(),
                    objNode.get("maxVersion").asInt(),
                    objNode.get("minVersion").asInt(),
                    objNode.get("path").asText());
            if (objNode.has("requestFormat")) {
                api.setRequestFormat(objNode.get("requestFormat").asText());
            }
            apis.add(api);
        }

        return new InfoData(apis);
    }
}
