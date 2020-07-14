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
    assertEquals(0, VictoryPointsCalculator.calculate(player));
  }
}
