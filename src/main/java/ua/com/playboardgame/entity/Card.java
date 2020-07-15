package ua.com.playboardgame.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Card {

  private final int age;
  private final String name;
  private Set<Integer> frequency;
  private CardType type;
  private List<Cost> cost;
  private Set<Card> chains;
  private Effect effect;

  public Card(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public Set<Integer> getFrequency() {
    return frequency;
  }

  public void setFrequency(Set<Integer> frequency) {
    this.frequency = frequency;
  }

  public CardType getType() {
    return type;
  }

  public void setType(CardType type) {
    this.type = type;
  }

  public List<Cost> getCost() {
    return cost;
  }

  public void setCost(List<Cost> cost) {
    this.cost = cost;
  }

  public Set<Card> getChains() {
    return chains;
  }

  public void setChains(Set<Card> chains) {
    this.chains = chains;
  }

  public Effect getEffect() {
    return effect;
  }

  public void setEffect(Effect effect) {
    this.effect = effect;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(name, card.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
