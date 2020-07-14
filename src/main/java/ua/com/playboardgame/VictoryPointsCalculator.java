package ua.com.playboardgame;

public class VictoryPointsCalculator {

  public static int calculate(Player player) {
    return player.getCoins() / 3;
  }
}
