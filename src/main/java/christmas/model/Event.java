package christmas.model;

import christmas.constant.number.Number;

/**
 * 이벤트 로직 처리 (할인, 증정, 이벤트 배지)
 */
public class Event {

  private final Order order;

  public Event(Order order) {
    this.order = order;
  }


  // 크리스마스 디데이 할인 금액
  public int christmasDdayDiscount(int date) {
    if(date > Number.CHRISTMAS_D_DAY_LIMIT.getNumber()) return 0;
    return Number.CHRISTMAS_D_DAY_START.getNumber() + Number.CHRISTMAS_D_DAY_DAY.getNumber() * (date-1);
  }




}
