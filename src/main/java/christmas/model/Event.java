package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.number.Number;
import christmas.constant.number.SpecialDay;

/**
 * 이벤트 로직 처리 (할인, 증정, 이벤트 배지)
 */
public class Event {


  // 혜택 내역 집계
  public void benefit() {

  }

  // 크리스마스 디데이 할인 금액
  public int christmasDdayDiscount(int date) {
    if(date > Number.CHRISTMAS_D_DAY_LIMIT.getNumber()) return Number.NOTHING.getNumber();
    return Number.CHRISTMAS_D_DAY_START.getNumber() + Number.CHRISTMAS_D_DAY_DAY.getNumber() * (date-1);
  }

  // 날짜 평일, 주말 확인
  // 평일 : true, 주말 : false
  public boolean checkWeekdayOrWeekend(int date) {
    int number = date % 7;
    if(number == 1 || number == 2) {
      return false;
    }
    return true;
  }

  // 평일 할인 금액 계산 - 디저트 할인
  public int weekdayDiscount(Order order) {
    return order.countDessertMenu() * Number.WEEKDAY_DISCOUNT.getNumber();
  }

  // 주말 할인 금액 계산 - 메인 메뉴 할인
  public int weekendDiscount(Order order) {
    return order.countMainMenu() * Number.WEEKEND_DISCOUNT.getNumber();
  }

  // 특별 할인
  public int specialDiscount(int date) {
    for(SpecialDay specialDay : SpecialDay.values()) {
      if (specialDay.getDay() == date) {
        return Number.SPECIAL_DISCOUNT.getNumber();
      }
    }
    return Number.NOTHING.getNumber();
  }

  // 증정 이벤트 계산
  public int giveawayEvent(Order order) {
    if (order.calculateOrderMoney() >= Number.GIVEAWAY_LIMIT_MONEY.getNumber()) {
      return Menu.CHAMPAGNE.getPrice();
    }
    return Number.NOTHING.getNumber();
  }





}
