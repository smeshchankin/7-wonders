package ua.com.playboardgame.effect;

public enum ProvidersEnum {
  LEFT("left"), RIGHT("right"), SELF("self");
  private final String name;

  ProvidersEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
