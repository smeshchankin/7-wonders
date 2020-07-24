package ua.com.playboardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.com.playboardgame.effect.ScienceSymbol;
import ua.com.playboardgame.effect.VictoryPoint;
import ua.com.playboardgame.entity.Card;
import ua.com.playboardgame.entity.CardType;
import ua.com.playboardgame.entity.Player;

public class VictoryPointsCalculatorTest {

  private Player player;

  @BeforeEach
  void init() {
    player = new Player(1, "John");
  }

  @Test
  void testCalculationForNewPlayer() {
    assertEquals(0, getPoints());
  }

  @ParameterizedTest
  @CsvSource(value = {"0:0", "1:0", "36:12", "38: 12", "39:13"}, delimiter = ':')
  void testCalculationForCoins(int coins, int points) {
    player.setCoins(coins);
    assertEquals(points, getPoints());
  }

  @Test
  void testCalculationForCivilianCard() {
    player.addCard(cardBuilder(1, "Altar", 2));
    assertEquals(2, getPoints());
  }

  @Test
  void testCalculationForCivilianCards() {
    player.addCard(cardBuilder(1, "Altar", 2));
    player.addCard(cardBuilder(2, "Aqueduct", 5));
    player.addCard(cardBuilder(3, "Senate", 6));
    player.addCard(cardBuilder(3, "Palace", 8));
    assertEquals(21, getPoints());
  }

  @Test
  void testCalculationForTwoDifferentScienceCards() {
    player.addCard(buildScienceCard(1, "Apothecary", "compass"));
    player.addCard(buildScienceCard(1, "Workshop", "gear"));
    assertEquals(2, getPoints());
  }

  @Test
  void testCalculationForAllByOneScienceCards() {
    player.addCard(buildScienceCard(1, "Apothecary", "compass"));
    player.addCard(buildScienceCard(1, "Workshop", "gear"));
    player.addCard(buildScienceCard(1, "Scriptorium", "table"));
    assertEquals(10, getPoints());
  }

  @Test
  void testCalculationForSingleScienceCard() {
    player.addCard(buildScienceCard(1, "Scriptorium", "table"));
    player.addCard(buildScienceCard(2, "Library", "table"));
    player.addCard(buildScienceCard(2, "School", "table"));
    player.addCard(buildScienceCard(3, "University", "table"));
    assertEquals(16, getPoints());
  }

  @Test
  void testCalculationForAllScienceCard() {
    player.addCard(buildScienceCard(1, "Apothecary", "compass"));
    player.addCard(buildScienceCard(1, "Workshop", "gear"));
    player.addCard(buildScienceCard(1, "Scriptorium", "table"));
    player.addCard(buildScienceCard(2, "Library", "table"));
    player.addCard(buildScienceCard(2, "Laboratory", "gear"));
    player.addCard(buildScienceCard(2, "Dispensary", "compass"));
    player.addCard(buildScienceCard(2, "School", "table"));
    player.addCard(buildScienceCard(3, "University", "table"));
    player.addCard(buildScienceCard(3, "Observatory", "gear"));
    player.addCard(buildScienceCard(3, "Lodge", "compass"));
    player.addCard(buildScienceCard(3, "Study", "gear"));
    player.addCard(buildScienceCard(3, "Academy", "compass"));
    assertEquals(16 * 3 + 7 * 4, getPoints());
  }

  private int getPoints() {
    return VictoryPointsCalculator.calculate(player);
  }

  private Card cardBuilder(int age, String name, int points) {
    Card card = new Card(age, name);
    card.setType(CardType.BLUE);
    card.setEffect(new VictoryPoint(points));
    return card;
  }

  private Card buildScienceCard(int age, String name, String symbol) {
    Card card = new Card(age, name);
    card.setEffect(new ScienceSymbol(symbol));
    return card;
  }
}
