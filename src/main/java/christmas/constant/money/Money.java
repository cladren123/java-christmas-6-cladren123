package christmas.constant.money;

public enum Money {

  CHRISTMAS_D_DAY_START(1000),
  CHRISTMAS_D_DAY_DAY(100),
  WEEKDAY_DISCOUNT(2023),
  WEEKEND_DISCOUNT(2023),
  SPECIAL_DISCOUNT(1000);


  private final int price;

  Money(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }
}
