package christmas.view;


import camp.nextstep.edu.missionutils.Console;
import christmas.constant.message.InputMessage;

/**
 * 입력 화면 출력
 */
public class InputView {

  // 환영 인사
  public void welcome() {
    System.out.println(InputMessage.WELCOME);
  }

  // 날짜 입력
  public String readDate() {
    System.out.println(InputMessage.READ_DATE);
    String inputDate = Console.readLine();
    return inputDate;
  }

  // 메뉴 입력
  public String readMenu() {
    System.out.println(InputMessage.READ_MENU);
    String inputMenu = Console.readLine();
    return inputMenu;
  }

}
