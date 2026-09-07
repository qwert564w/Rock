package rockstar.client.internal.config;



import rockstar.client.data.*;
import rockstar.client.*;
import java.util.function.Function;
import java.util.stream.Collector;
import rockstar.client.data.JsonArrayNode;
import rockstar.client.data.JsonNode;
import rockstar.client.data.JsonObjectNode;

public class ConfigInternal002 {
    public static <T extends JsonNode> Collector<T, ?, JsonArrayNode> internalMethod04168() {
        return Collector.of(JsonArrayNode::new, JsonArrayNode::internalMethod07220, (typedValue026, typedValue027) -> {
            if (typedValue026.internalMethod06015()) {
                return typedValue027;
            }
            if (typedValue027.internalMethod06015()) {
                return typedValue026;
            }
            JsonArrayNode typedValue028 = new JsonArrayNode();
            typedValue028.internalMethod06065((JsonArrayNode)typedValue026);
            typedValue028.internalMethod06065((JsonArrayNode)typedValue027);
            return typedValue028;
        }, new Collector.Characteristics[0]);
    }

    public static <P, V extends JsonNode> Collector<P, ?, JsonObjectNode> internalMethod00672(Function<P, String> function, Function<P, V> function2) {
        return Collector.of(JsonObjectNode::new, (typedValue030, object) -> typedValue030.internalMethod05254((String)function.apply(object), (JsonNode)function2.apply(object)), (typedValue030, typedValue031) -> {
            if (typedValue030.internalMethod00948()) {
                return typedValue031;
            }
            if (typedValue031.internalMethod00948()) {
                return typedValue030;
            }
            JsonObjectNode typedValue032 = new JsonObjectNode();
            typedValue032.internalMethod01558((JsonObjectNode)typedValue030);
            typedValue032.internalMethod01558((JsonObjectNode)typedValue031);
            return typedValue032;
        }, new Collector.Characteristics[0]);
    }
}

