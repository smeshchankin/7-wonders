package ua.com.playboardgame.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    player.setCoins(1);
    assertEquals(1, player.getCoins());
  }

  @Test
  void testPlayerHasEmptyCardsSet() {
    assertNotNull(player.getCards());
    assertEquals(0, player.getCards().size(), "Player has empty cards set");
  }

  @Test
  void testPlayerAddingCards() {
    player.addCard(new Card(1, "Card 1"));
    player.addCard(new Card(1, "Card 2"));
    assertEquals(2, player.getCards().size());
  }

  @Test
  void testPlayerAddingEqualsCards() {
    boolean[] expected = new boolean[] { true, true, false, true };
    boolean[] actual = new boolean[] {
        player.addCard(new Card(1, "Card 1")),
        player.addCard(new Card(1, "Card 2")),
        player.addCard(new Card(1, "Card 2")),
        player.addCard(new Card(1, "Card 3")),
    };
    assertArrayEquals(expected, actual, "Check Card adding result");
    assertEquals(3, player.getCards().size());
  }
}