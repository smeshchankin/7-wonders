package ua.com.playboardgame;

import java.util.Map;
import java.util.stream.Collectors;
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

    Map<String, Long> scienceSymbols = player.getCards().stream()
        .map(Card::getEffect)
        .filter(effect -> effect instanceof ScienceSymbol)
        .collect(Collectors.groupingBy(effect -> ((ScienceSymbol) effect).getSymbol(), Collectors.counting()));

    int rows = scienceSymbols.values().stream().mapToInt(Math::toIntExact).min().orElse(0);
    int science = scienceSymbols.size() == 3 ? rows * 7 : 0;
    science += scienceSymbols.values().stream()
      .mapToInt(count -> Math.toIntExact(count * count)).sum();

    return points + player.getCoins() / 3 + science;
  }
}
