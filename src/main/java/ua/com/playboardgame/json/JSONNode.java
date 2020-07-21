package ua.com.playboardgame.json;

import java.util.HashMap;
import java.util.Map;

public class JSONNode {
  private JSONType type = null;
  private final Map<String, JSONNode> nodes = new HashMap<>();

  public static JSONNode parse(String json) {
    return new JSONNode();
  }

  public JSONType getType() {
    return type;
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
