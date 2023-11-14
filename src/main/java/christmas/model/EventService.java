package christmas.model;


import christmas.constant.menu.Menu;
import christmas.constant.message.BenefitMessage;
import christmas.constant.message.OutputMessage;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 로직 처리
 */
public class EventService {

  private final Order order;
  private final Event event;

  public EventService(int date, Map<String, Integer> order) {
    this.order = new Order(date, order);
    this.event = new Event(this.order);
  }

  // 할인 전 총 주문 금액
  public int orderMoney() {
    return order.calculateOrderMoney();
  }

  // 증정 메뉴
  public String giveaway() {
    if(order.giveawayEvent() == Menu.CHAMPAGNE.getPrice()) {
      return OutputMessage.GIVEAWAY_MENU.getMessage();
    }
    return OutputMessage.NOTHING.getMessage();
  }

  // 혜택 내용 : 0 제외
  public Map<BenefitMessage, Integer> benefit() {
    Map<BenefitMessage, Integer> result = new HashMap<>();
    Map<BenefitMessage, Integer> benefit = event.getBenefit();
    for (BenefitMessage benefitMessage : benefit.keySet()) {
      if(benefit.get(benefitMessage) > 0) {
        result.put(benefitMessage, benefit.get(benefitMessage));
      }
    }
    return result;
  }

  // 총 혜택 금액
  public int benefitMoney() {
    return event.discountMoney();
  }

  // 할인 후 예상 결제 금액
  public int orderMoneyAfterBenefit() {
    return order.calculateOrderMoney() - event.discountMoney();
  }

  // 12월 이벤트 뱃지
  public String badgeEvent() {
    return event.badgeEvent();
  }




}
