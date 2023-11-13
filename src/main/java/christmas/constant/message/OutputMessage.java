package christmas.constant.message;

/**
 * 출력단에 사용하는 메세지 관리
 */
public enum OutputMessage {

  INTRO("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
  ORDER_MENU("<주문 메뉴>\n"),
  ORDER_MONEY("<할인 전 총주문 금액>\n"),
  GIVEAWAY_MENU("<증정 메뉴>\n"),
  BENEFIT("<혜택 내역>\n"),
  BENEFIT_MONEY("<총혜택 금액>\n"),
  ORDER_MONEY_AFTER_DISCOUNT("<할인 후 예상 결제 금액>\n"),
  EVENT_BADGE("<12월 이벤트 배지>\n");

  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }




}
