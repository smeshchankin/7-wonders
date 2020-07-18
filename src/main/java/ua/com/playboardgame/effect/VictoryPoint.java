package ua.com.playboardgame.effect;

public class VictoryPoint implements Effect {
  private final int points;

  public VictoryPoint(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }
}
