package christmas.controller;

import christmas.view.InputView;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  private final InputView inputView;

  // 생성자 주입
  EventPlanner(InputView inputView) {
    this.inputView = inputView;
  }

  public void start() {


  }

  // 날짜 입력
  public int readDate() {
    // todo : 검증 클래스와 올바른 입력이 올 때까지 반복 구현
    String inputDate = inputView.readDate();
    int date = Integer.parseInt(inputDate);
    return date;
  }

}
