package ua.com.playboardgame.json;

import java.util.HashMap;
import java.util.Map;

public class JSONNode {
  private final Map<String, JSONNode> nodes = new HashMap<>();
  private final Map<String, String> leafs = new HashMap<>();

  public void addLeaf(String name, String value) {
    leafs.put(name, value);
  }

  public void addNode(String name, JSONNode node) {
    nodes.put(name, node);
  }
}
