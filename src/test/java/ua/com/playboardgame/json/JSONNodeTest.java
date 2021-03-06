package ua.com.playboardgame.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JSONNodeTest {

  @Test
  void parseNullJSON() {
    testNullObject(JSONNode.parse(null));
  }

  @Test
  void parseEmptyJSON() {
    testNullObject(JSONNode.parse(""));
  }

  @Test
  void parseMinimizeJSON() {
    testNullObject(JSONNode.parse("{}"));
  }

  @Test
  void parseKeyValuePair() {
    JSONNode json = JSONNode.parse("{ \"name\": \"value\" }");
    assertNotNull(json);
    assertEquals(JSONType.OBJECT, json.getType());
    assertNotNull(json.getNodes());
    assertEquals(1, json.getNodes().size());
    JSONNode value = json.getNodes().get("name");
    assertNotNull(value);
    assertEquals("value", value.getValue());
  }

  @Test
  void parseSimpleKeyValueObject() {
    String str = "{ \"name\": \"John\", \"age\": 21, \"city\": \"London\", \"dev\": true }";
    JSONNode json = JSONNode.parse(str);
    assertNotNull(json);
    assertEquals(JSONType.OBJECT, json.getType());
    assertNotNull(json.getNodes());
    assertEquals(4, json.getNodes().size());
    testKeyValue(json, "name", "John", JSONType.STRING);
    testKeyValue(json, "age", 21L, JSONType.NUMBER);
    testKeyValue(json, "city", "London", JSONType.STRING);
    testKeyValue(json, "dev", true, JSONType.BOOLEAN);
  }

  @Test
  void parseNestedObjects() {
    String str = "{ \"name\": \"John\", \"age\": 21, \"child\": "
        + "{ \"name\": \"Mary\", \"year\": 2020 }"
        + "}";
    JSONNode json = JSONNode.parse(str);
    System.out.println(json);
  }

  private void testNullObject(JSONNode json) {
    assertNotNull(json);
    assertEquals(JSONType.NULL, json.getType());
    assertNotNull(json.getNodes());
    assertEquals(0, json.getNodes().size());
  }

  private void testKeyValue(JSONNode json, String name, Object value, JSONType type) {
    JSONNode node = json.getNodes().get(name);
    assertNotNull(node);
    assertEquals(value, node.getValue());
    assertEquals(type, node.getType());
  }
}