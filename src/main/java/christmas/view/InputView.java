package christmas.view;


import camp.nextstep.edu.missionutils.Console;
import christmas.constant.message.InputMessage;

/**
 * 입력 화면 출력
 */
public class InputView {

  // 환영 인사
  public static void welcome() {
    System.out.println(InputMessage.WELCOME.getMessage());
  }

  // 날짜 입력
  public static String readDate() {
    System.out.println(InputMessage.READ_DATE.getMessage());
    String inputDate = Console.readLine();
    return inputDate;
  }

  // 메뉴 입력
  public static String readMenu() {
    System.out.println(InputMessage.READ_MENU.getMessage());
    String inputMenu = Console.readLine();
    return inputMenu;
  }

}
