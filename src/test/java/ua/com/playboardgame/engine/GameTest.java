package ua.com.playboardgame.engine;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.com.playboardgame.entity.Card;
import ua.com.playboardgame.entity.Player;
import ua.com.playboardgame.entity.Wonder;
import ua.com.playboardgame.service.CardService;

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

  @Test
  void testGetCardsByAge() {
    List<Card> mockResult = Arrays.asList(
        buildCard(1, "Lumber Yard"),
        buildCard(1, "Stone Pit"),
        buildCard(1, "Glassworks"),
        buildCard(1, "Marketplace"),
        buildCard(1, "Baths"),
        buildCard(1, "Barracks")
    );
    initGame(mockResult);
    List<Card> actual = game.getCardsByAge(1);
    assertEquals(mockResult, actual, "Get cards by Age I");
  }

  @Test
  void testGetCardsByAgeFromAll() {
    List<Card> mockResult = Arrays.asList(
        buildCard(1, "Lumber Yard"),
        buildCard(1, "Stone Pit"),
        buildCard(1, "Glassworks"),
        buildCard(1, "Marketplace"),
        buildCard(1, "Baths"),
        buildCard(1, "Barracks"),
        buildCard(2, "Quarry"),
        buildCard(2, "Loom"),
        buildCard(2, "Statue"),
        buildCard(2, "Walls"),
        buildCard(3, "Pantheon"),
        buildCard(3, "Arsenal")
    );
    initGame(mockResult);
    for (int i = 0; i < 3; ++i) {
      final int age = i + 1;
      List<Card> actual = game.getCardsByAge(age);
      List<Card> expected = mockResult.stream()
        .filter(card -> card.getAge() == age)
        .collect(Collectors.toList());
      assertEquals(expected, actual, "Get cards by Age " + age);
    }
  }

  private boolean addPlayer(long id, String name) {
    return game.addPlayer(new Player(id, name,
      new Wonder("Gizah (A)", null, Collections.emptyList())));
  }

  private Card buildCard(int age, String name) {
    return new Card(age, name);
  }

  private void initGame(List<Card> allCards) {
    CardService cardServiceMock = Mockito.mock(CardService.class);
    Mockito.when(cardServiceMock.load()).thenReturn(allCards);

    game.setCardService(cardServiceMock);
    game.init();
  }
}
