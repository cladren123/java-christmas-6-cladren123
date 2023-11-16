package christmas.constant.badge;

public enum EventBadge {
  NOTHING("없음", 0),
  STAR("별", 5000),
  TREE("트리", 10000),
  SANTA("산타", 20000);


  private String name;
  private int price;

  EventBadge(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
