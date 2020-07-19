package ua.com.playboardgame.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ua.com.playboardgame.entity.Card;
import ua.com.playboardgame.entity.Player;
import ua.com.playboardgame.service.CardService;

public class Game {
  private static final int MAX_PLAYERS = 7;

  private CardService cardService = new CardService();

  private final List<Player> players = new ArrayList<>();
  // All cards with key = age, value = list of cards
  private Map<Integer, List<Card>> cards = new HashMap<>();

  public boolean addPlayer(Player player) {
    if (players.size() >= MAX_PLAYERS || players.contains(player)) {
      return false;
    }

    return players.add(player);
  }

  public void init() {
    cards = cardService.load()
      .stream()
      .collect(Collectors.groupingBy(Card::getAge));
  }

  public List<Card> getCardsByAge(int age) {
    return cards.get(age);
  }

  public void setCardService(CardService cardService) {
    this.cardService = cardService;
  }
}
