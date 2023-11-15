package christmas.model;


import christmas.constant.menu.Menu;
import christmas.constant.message.BenefitMessage;
import christmas.validator.Validate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 데이터 변환기
 */
public class Converter {

  // String에서 Menu 변환
  public static Map<Menu, Integer> convertOrder(Map<String, Integer> inputOrder) {
    Map<Menu, Integer> order = new LinkedHashMap<>();
    for(String name : inputOrder.keySet()) {
      Menu menu = Validate.validateMenu(name);
      order.put(menu, inputOrder.get(name));
    }
    return order;
  }

  // 혜택 집계
  public static Map<BenefitMessage, Integer> benefitTotal(Order order) {
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>();
    benefit.put(BenefitMessage.CHRISTMAS_D_DAY,order.christmasDdayDiscount());
    benefit.putAll(order.dayDiscount());
    benefit.put(BenefitMessage.SPECIAL_DISCOUNT, order.specialDiscount());
    benefit.put(BenefitMessage.GIVEAWAY_EVENT, order.giveawayEvent());
    return benefit;
  }
}
