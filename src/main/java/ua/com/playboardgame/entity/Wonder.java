package ua.com.playboardgame.entity;

import java.util.List;
import ua.com.playboardgame.effect.Effect;

public class Wonder {
  private String name;
  private Effect effect;
  private List<Stage> stages;

  public Wonder(String name, Effect effect, List<Stage> stages) {
    this.name = name;
    this.effect = effect;
    this.stages = stages;
  }

  public String getName() {
    return name;
  }

  public Effect getEffect() {
    return effect;
  }

  public List<Stage> getStages() {
    return stages;
  }
}
