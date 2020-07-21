package ua.com.playboardgame.json;

public enum JSONType {
  OBJECT("object"),
  ARRAY("array"),
  STRING("string"),
  NUMBER("number"),
  BOOLEAN("boolean"),
  NULL(null);

  private String name;

  JSONType(String name) {
    this.name = name;
  }
}
