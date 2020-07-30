package ua.com.playboardgame.effect;

import java.util.List;

public class BoardElement {
  private final String type; // card, stage, token
  private final String value; // card color or token name
  private final int points; // points per each value
  private final List<ProvidersEnum> providers;

  public BoardElement(String type, String value, int points, List<ProvidersEnum> providers) {
    this.type = type;
    this.value = value;
    this.points = points;
    this.providers = providers;
  }

  public String getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public int getPoints() {
    return points;
  }

  public List<ProvidersEnum> getProviders() {
    return providers;
  }
}
