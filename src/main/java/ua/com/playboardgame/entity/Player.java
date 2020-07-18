package ua.com.playboardgame.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {

  private final long id;
  private final String name;
  private int coins;
  private final Set<Card> cards = new HashSet<>();

  public Player(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getCoins() {
    return coins;
  }

  public void setCoins(int coins) {
    this.coins = coins;
  }

  public Set<Card> getCards() {
    return cards;
  }

  /**
   * Method for adding Card to the player hand
   * @param card Card object
   * @return true - if card was successfully  added, false - if card is already exists in player hand
   */
  public boolean addCard(Card card) {
    return cards.add(card);
  }

  @Override
  public String toString() {
    return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return id == player.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
