package christmas.constant;

public enum AppetizerMenu {

  MUSHROOM_SOUP("양송이수프", 6000),
  TAPAS("타파스", 5500),
  CAESAR_SALAD("시저샐러드", 8000);

  private String name;
  private Integer price;

  AppetizerMenu(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }


}
