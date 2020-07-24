package ua.com.playboardgame;

import ua.com.playboardgame.effect.ScienceSymbol;
import ua.com.playboardgame.effect.VictoryPoint;
import ua.com.playboardgame.entity.Card;
import ua.com.playboardgame.entity.Player;

public class VictoryPointsCalculator {

  public static int calculate(Player player) {
    int points = player.getCards().stream()
      .map(Card::getEffect)
      .filter(effect -> effect instanceof VictoryPoint)
      .mapToInt(effect -> ((VictoryPoint) effect).getPoints())
      .sum();

    int science = (int) player.getCards().stream()
      .map(Card::getEffect)
      .filter(effect -> effect instanceof ScienceSymbol)
      .map(effect -> ((ScienceSymbol) effect).getSymbol())
      .count();

    return points + player.getCoins() / 3 + science;
  }
}
