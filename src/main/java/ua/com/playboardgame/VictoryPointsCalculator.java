package ua.com.playboardgame;

import ua.com.playboardgame.entity.Player;

public class VictoryPointsCalculator {

  public static int calculate(Player player) {
    return player.getCoins() / 3;
  }
}
