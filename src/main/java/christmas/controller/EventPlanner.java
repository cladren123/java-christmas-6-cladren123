package christmas.controller;

import christmas.constant.message.ErrorMessage;
import christmas.constant.message.InputMessage;
import christmas.model.InputConverter;
import christmas.validator.Validate;
import christmas.view.InputView;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  private final InputView inputView = new InputView();
  private final InputConverter inputConverter = new InputConverter();



  public void start() {
    System.out.println(InputMessage.WELCOME.getMessage());
    int date = readDate();


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




}
