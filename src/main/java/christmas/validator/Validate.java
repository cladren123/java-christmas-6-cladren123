package christmas.validator;


import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import jdk.jfr.Category;

import java.io.IOException;
import java.util.Map;

/**
 * 검증 작업을 수행하는 클래스
 */
public class Validate {

  // 숫자인지 검증
  public void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

  // 날짜의 범위 검증
  public void validateDateNumberRange(int date) {
    if(date < 1 || date > 31) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴가 있는지 검증
  public Menu validateMenu(String name) {
    for(Menu menu : Menu.values()) {
      if (menu.getName().equals(name)) {
        return menu;
      }
    }
    throw new IllegalArgumentException();
  }








}
