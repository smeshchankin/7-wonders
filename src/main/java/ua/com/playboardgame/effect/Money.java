package ua.com.playboardgame.effect;

import ua.com.playboardgame.entity.Cost;

public class Money implements Effect, Cost {
  private final int value;

  public Money(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
