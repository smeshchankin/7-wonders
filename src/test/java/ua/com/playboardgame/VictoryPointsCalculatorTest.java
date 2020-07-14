package ua.com.playboardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VictoryPointsCalculatorTest {

  private Player player;

  @BeforeEach
  void init() {
    player = new Player(1, "John");
  }

  @ParameterizedTest
  @CsvSource(value = {"0:0", "1:0", "36:12", "38: 12", "39:13"}, delimiter = ':')
  void testCalculationForCoins(int coins, int points) {
    player.setCoins(coins);
    assertEquals(points, getPoints());
  }

  private int getPoints() {
    return VictoryPointsCalculator.calculate(player);
  }
}
