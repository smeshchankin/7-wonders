package ua.com.playboardgame;

public class Player {

  private final long id;
  private final String name;
  private long coins;

  public Player(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getCoins() {
    return coins;
  }

  public void setCoins(long coins) {
    this.coins = coins;
  }

  @Override
  public String toString() {
    return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
