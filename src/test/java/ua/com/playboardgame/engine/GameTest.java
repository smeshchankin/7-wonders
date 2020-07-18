package ua.com.playboardgame.engine;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.playboardgame.entity.Player;

class GameTest {
  private Game game;

  @BeforeEach
  void init() {
    game = new Game();
  }

  @Test
  void addOnePlayer() {
    boolean result = addPlayer(1, "John");
    assertTrue(result, "Player was added to the game");
  }

  @Test
  void addTwoPlayers() {
    boolean[] expected = new boolean[] { true, true };
    boolean[] actual = new boolean[] {
        addPlayer(1, "John"),
        addPlayer(2, "Diana")
    };
    assertArrayEquals(expected, actual, "Adding players test");
  }

  @Test
  void addTwoEqualsPlayers() {
    boolean[] expected = new boolean[] { true, false };
    boolean[] actual = new boolean[] {
        addPlayer(1, "John"),
        addPlayer(1, "Diana")
    };
    assertArrayEquals(expected, actual, "Adding equals players test");
  }

  @Test
  void addMoreThanSevenPlayers() {
    boolean[] expected = new boolean[] { true, true, true, true, true, true, true, false, false };
    boolean[] actual = new boolean[] {
        addPlayer(1, "John"),
        addPlayer(2, "Diana"),
        addPlayer(3, "Harley"),
        addPlayer(4, "Angel"),
        addPlayer(5, "Kerry"),
        addPlayer(6, "Sam"),
        addPlayer(7, "Jessie"),
        addPlayer(8, "Logan"),
        addPlayer(9, "Kris"),
    };
    assertArrayEquals(expected, actual, "Adding more than 7 players");
  }

  private boolean addPlayer(long id, String name) {
    return game.addPlayer(new Player(id, name));
  }
}