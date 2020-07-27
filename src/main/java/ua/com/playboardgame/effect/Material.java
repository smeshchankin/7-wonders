package ua.com.playboardgame.effect;

import ua.com.playboardgame.entity.Cost;

public class Material implements Effect, Cost {
  private final String name;

  public Material(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
