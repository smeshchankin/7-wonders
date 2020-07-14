package ua.com.playboardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VictoryPointsCalculatorTest {

  private Player player;

  @BeforeEach
  void init() {
    player = new Player(1, "John");
  }

  @Test
  void testCalculationFor0Coins() {
    player.setCoins(0);
    assertEquals(0, getPoints());
  }

  @Test
  void testCalculationForMultiple3Coins() {
    player.setCoins(3*12);
    assertEquals(12, getPoints());
  }

  @Test
  void testCalculationForRestCoins() {
    player.setCoins(3*12 + 2);
    assertEquals(12, getPoints());
  }

  private int getPoints() {
    return VictoryPointsCalculator.calculate(player);
  }
}
