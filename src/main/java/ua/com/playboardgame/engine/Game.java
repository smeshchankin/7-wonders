package ua.com.playboardgame.engine;

import java.util.ArrayList;
import java.util.List;
import ua.com.playboardgame.entity.Player;

public class Game {
  private static final int MAX_PLAYERS = 7;

  private final List<Player> players = new ArrayList<>();

  public boolean addPlayer(Player player) {
    if (players.size() >= MAX_PLAYERS || players.contains(player)) {
      return false;
    }

    return players.add(player);
  }
}
