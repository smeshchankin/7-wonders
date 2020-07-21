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

  public JSONNode(String value) {
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
      String[] arr = pair.replace("\"", "").split(":");
      root.nodes.put(arr[0].trim(), new JSONNode(arr[1].trim()));
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
