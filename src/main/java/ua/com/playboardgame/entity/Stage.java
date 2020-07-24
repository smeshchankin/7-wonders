package ua.com.playboardgame.entity;

import java.util.List;
import ua.com.playboardgame.effect.Effect;

public class Stage {
  private int order;
  private List<Cost> cost;
  private Effect effect;

  public Stage(int order, List<Cost> cost, Effect effect) {
    this.order = order;
    this.cost = cost;
    this.effect = effect;
  }

  public int getOrder() {
    return order;
  }

  public List<Cost> getCost() {
    return cost;
  }

  public Effect getEffect() {
    return effect;
  }
}
