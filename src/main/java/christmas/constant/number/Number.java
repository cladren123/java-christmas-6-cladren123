package christmas.constant.number;

public enum Number {

  NOTHING(0),
  CHRISTMAS_D_DAY_LIMIT(25),
  CHRISTMAS_D_DAY_START(1000),
  CHRISTMAS_D_DAY_DAY(100),
  WEEKDAY_DISCOUNT(2023),
  WEEKEND_DISCOUNT(2023),
  SPECIAL_DISCOUNT(1000),
  GIVEAWAY_LIMIT_MONEY(120000);



  private final int number;

  Number(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }
}
