package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import christmas.constant.message.BenefitMessage;
import christmas.constant.number.Number;
import christmas.constant.number.SpecialDay;
import christmas.validator.Validate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 주문과 비즈니스 로직을 처리
 */
public class Order {

  private final int date;
  private final Map<Menu, Integer> order;

  // 생성자
  public Order(int date, Map<Menu, Integer> order) {
    this.date = date;
    Validate.validateMenuOnlyBeverage(order);
    Validate.validateMenuMaximum(order);
    this.order = order;
  }


  // 날짜 반환
  public int getDate() {
    return date;
  }

  // 메뉴 목록 반환
  public Map<String, Integer> orderMenu() {
    Map<String, Integer> result = new LinkedHashMap<>();
    for(Menu menu : order.keySet()) {
      result.put(menu.getName(), order.get(menu));
    }
    return result;
  }

  // 디저트 메뉴 개수 집계
  public int countDessertMenu() {
    int count = 0;
    for(Menu menu : order.keySet()) {
      if(menu.getCategory().equals(MenuCategory.DESSERT)) {
        count += order.get(menu);
      }
    }
    return count;
  }


  // 메인 메뉴 개수 집계
  public int countMainMenu() {
    int count = 0;
    for(Menu menu : order.keySet()) {
      if(menu.getCategory().equals(MenuCategory.MAIN_COURSE)) {
        count += order.get(menu);
      }
    }
    return count;
  }

  // 총 주문 금액 계산
  public int calculateOrderMoney() {
    int money = 0;
    for(Menu menu : order.keySet()) {
      money += menu.getPrice() * order.get(menu);
    }
    return money;
  }

  // 할인

  // 크리스마스 디데이 할인 금액
  public int christmasDdayDiscount() {
    if(date > Number.CHRISTMAS_D_DAY_LIMIT.getNumber()) return Number.NOTHING.getNumber();
    return Number.CHRISTMAS_D_DAY_START.getNumber() + Number.CHRISTMAS_D_DAY_DAY.getNumber() * (date-1);
  }

  // 날짜 할인, 평일 주말에 해당하는 할인 적용
  public Map<BenefitMessage, Integer> dayDiscount() {
    Map<BenefitMessage, Integer> discount = new LinkedHashMap<>();
    if (checkWeekdayOrWeekend()) discount.put(BenefitMessage.WEEKDAY_DISCOUNT, weekdayDiscount());
    if (!checkWeekdayOrWeekend()) discount.put(BenefitMessage.WEEKEND_DISCOUNT, weekendDiscount());
    return discount;
  }

  // 날짜 평일, 주말 확인
  // 평일 : true, 주말 : false
  public boolean checkWeekdayOrWeekend() {
    int number = date % 7;
    if(number == 1 || number == 2) {
      return false;
    }
    return true;
  }

  // 평일 할인 금액 계산 - 디저트 할인
  public int weekdayDiscount() {
    return countDessertMenu() * Number.WEEKDAY_DISCOUNT.getNumber();
  }

  // 주말 할인 금액 계산 - 메인 메뉴 할인
  public int weekendDiscount() {
    return countMainMenu() * Number.WEEKEND_DISCOUNT.getNumber();
  }

  // 특별 할인
  public int specialDiscount() {
    for(SpecialDay specialDay : SpecialDay.values()) {
      if (specialDay.getDay() == date) {
        return Number.SPECIAL_DISCOUNT.getNumber();
      }
    }
    return Number.NOTHING.getNumber();
  }

  // 증정 이벤트 계산
  public int giveawayEvent() {
    if (calculateOrderMoney() >= Number.GIVEAWAY_LIMIT_MONEY.getNumber()) {
      return Menu.CHAMPAGNE.getPrice();
    }
    return Number.NOTHING.getNumber();
  }








}
