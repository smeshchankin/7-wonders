package ua.com.playboardgame.entity;

public enum CardType {
  BROWN("brown", "Raw Material"),
  GRAY("gray", "Manufactured Good"),
  BLUE("blue", "Civilian Structure"),
  GREEN("green", "Scientific Structure"),
  YELLOW("yellow", "Commercial Structure"),
  RED("red", "Military Structure"),
  PURPLE("purple", "Guild");

  private String color;
  private String name;

  CardType(String color, String name) {
    this.color = color;
    this.name = name;
  }
}
