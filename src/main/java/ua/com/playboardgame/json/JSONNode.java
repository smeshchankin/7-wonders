package ua.com.playboardgame.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JSONNode {
  private JSONType type = JSONType.NULL;
  private Object value = null;
  private final Map<String, JSONNode> nodes = new HashMap<>();

  public JSONNode() {
  }

  public JSONNode(Object value, JSONType type) {
    this.type = type;
    this.value = value;
  }

  public static JSONNode parse(String json) {
    JSONNode root = new JSONNode();
    if (json == null) {
      return root;
    }

    String str = json.replace("{", "").replace("}", "").trim();
    if ("".equals(str)) {
      return root;
    }

    root.type = JSONType.OBJECT;
    String[] pairs = str.split(",");
    Arrays.stream(pairs).forEach(pair -> {
      String[] arr = pair.split(":");
      String key = arr[0].replace("\"", "").trim();
      String val = arr[1].trim();
      Object value = val;

      JSONType type;
      if (val.startsWith("\"") && val.endsWith("\"")) {
        type = JSONType.STRING;
        value = val.replace("\"", "");
      } else if (val.startsWith("[") && val.endsWith("]")) {
        type = JSONType.ARRAY;
      } else if (val.startsWith("{") && val.endsWith("}")) {
        type = JSONType.OBJECT;
      } else if ("null".equals(val)) {
        type = JSONType.NULL;
        value = null;
      } else if ("true".equals(val)) {
        type = JSONType.BOOLEAN;
        value = true;
      } else if ("false".equals(val)) {
        type = JSONType.BOOLEAN;
        value = false;
      } else {
        try {
          value = Long.parseLong(val, 10);
          type = JSONType.NUMBER;
        } catch (NumberFormatException cause) {
          try {
            value = Double.parseDouble(val);
            type = JSONType.NUMBER;
          } catch (NumberFormatException exception) {
            type = JSONType.NULL;
            System.err.println("Can't parse JSON value = " + val);
          }
        }
      }

      root.nodes.put(key, new JSONNode(value, type));
    });

    return root;
  }

  public JSONType getType() {
    return type;
  }

  public Object getValue() {
    return value;
  }

  public Map<String, JSONNode> getNodes() {
    return nodes;
  }

  @Override
  public String toString() {
    if (type == null) {
      return "null";
    } else {
      return "";
    }
  }
}
