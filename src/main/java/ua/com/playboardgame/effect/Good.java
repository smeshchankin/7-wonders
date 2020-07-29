package ua.com.playboardgame.effect;

import ua.com.playboardgame.entity.Cost;

public class Good implements Effect, Product, Cost {
  private final String name;

  public Good(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
