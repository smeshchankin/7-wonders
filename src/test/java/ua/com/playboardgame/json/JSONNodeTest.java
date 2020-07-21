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
    testKeyValue(json, "name", "John");
    testKeyValue(json, "age", "21");
    testKeyValue(json, "city", "London");
    testKeyValue(json, "dev", "true");
  }

  private void testNullObject(JSONNode json) {
    assertNotNull(json);
    assertEquals(JSONType.NULL, json.getType());
    assertNotNull(json.getNodes());
    assertEquals(0, json.getNodes().size());
  }

  private void testKeyValue(JSONNode json, String name, String value) {
    JSONNode node = json.getNodes().get(name);
    assertNotNull(node);
    assertEquals(value, node.getValue());
  }
}