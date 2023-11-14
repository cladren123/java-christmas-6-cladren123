package christmas.controller;

import christmas.constant.message.ErrorMessage;
import christmas.constant.message.InputMessage;
import christmas.model.Event;
import christmas.model.EventService;
import christmas.model.InputConverter;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.mockito.internal.matchers.Or;

import java.util.Map;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  private final InputView inputView = new InputView();
  private final InputConverter inputConverter = new InputConverter();
  private final OutputView outputView = new OutputView();



  // 흐름 제어
  public void start() {
    inputView.welcome();
    EventService eventService = new EventService(readDate(), readOrder());
    print(eventService);
  }

  // 결과 출력
  public void print(EventService eventService) {
    outputView.printIntro(eventService.getDate());
    outputView.printMenu(eventService.orderMenu());
    outputView.printOrderMoney(eventService.orderMoney());
    outputView.printGiveaway(eventService.giveaway());
    outputView.printBenefit(eventService.benefit());
    outputView.printBenefitMoney(eventService.benefitMoney());
    outputView.printOrderMoneyAfterDiscount(eventService.orderMoneyAfterBenefit());
    outputView.printEventBadge(eventService.badgeEvent());
  }



  // 날짜 입력
  public int readDate() {
    while(true) {
      String input = inputView.readDate();
      try {
        return inputConverter.convertDate(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_DATE.getMessage());
      }
    }
  }

  // 메뉴 입력
  public Map<String, Integer> readOrder() {
    while (true) {
      String input = inputView.readMenu();
      try {
        return inputConverter.convertOrder(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_MENU.getMessage());
      }
    }
  }




}
