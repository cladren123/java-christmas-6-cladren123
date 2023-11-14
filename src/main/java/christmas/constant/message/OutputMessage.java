package christmas.constant.message;

/**
 * 출력단에 사용하는 메세지 관리
 */
public enum OutputMessage {

  INTRO("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
  NOTHING("없음"),
  ORDER_MENU("<주문 메뉴>"),
  ORDER_MENU_FORMAT("%s %d개"),
  ORDER_MONEY("<할인 전 총주문 금액>"),
  ORDER_MONEY_FORMAT("%,d원"),
  GIVEAWAY_MENU("<증정 메뉴>"),
  GIVEAWAY_MENU_TRUE("샴페인 1개"),
  BENEFIT("<혜택 내역>"),
  BENEFIT_FORMAT("%s: -%,d원"),
  BENEFIT_MONEY("<총혜택 금액>"),
  BENEFIT_MONEY_FORMAT("%,d원"),
  ORDER_MONEY_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
  ORDER_MONEY_AFTER_DISCOUNT_FORMAT("%,d원"),
  EVENT_BADGE("<12월 이벤트 배지>");

  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }




}
