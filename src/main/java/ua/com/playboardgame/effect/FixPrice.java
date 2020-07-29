package ua.com.playboardgame.effect;

import java.util.List;

public class FixPrice implements Effect {
  private final int cost;
  private final List<Product> products;
  private final List<ProvidersEnum> providers;

  public FixPrice(int cost, List<Product> products, List<ProvidersEnum> providers) {
    this.cost = cost;
    this.products = products;
    this.providers = providers;
  }
}
