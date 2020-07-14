package ua.com.playboardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private Player player;

  @BeforeEach
  void init() {
    player = new Player(1, "John");
  }

  @Test
  void testToString() {
    String expected = Player.class.getSimpleName() + "{id=1, name='John'}";
    assertEquals(expected, player.toString());
  }

  @Test
  void testPlayerCoins() {
    player.setCoins(1L);
    assertEquals(1L, player.getCoins());
  }
}