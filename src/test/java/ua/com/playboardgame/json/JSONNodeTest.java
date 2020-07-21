package ua.com.playboardgame.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

  private void testNullObject(JSONNode json) {
    assertNull(json.getType());
    assertNotNull(json.getNodes());
    assertEquals(0, json.getNodes().size());
  }
}