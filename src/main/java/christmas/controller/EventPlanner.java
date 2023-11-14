package christmas.controller;

import christmas.constant.message.ErrorMessage;
import christmas.constant.message.InputMessage;
import christmas.model.Event;
import christmas.model.EventService;
import christmas.model.InputConverter;
import christmas.model.Order;
import christmas.view.InputView;
import org.mockito.internal.matchers.Or;

import java.util.Map;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  private final InputView inputView = new InputView();
  private final InputConverter inputConverter = new InputConverter();



  // 흐름 제어
  public void start() {
    inputView.welcome();
    int date = readDate();
    EventService eventService = new EventService(readDate(), readOrder());
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
