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
