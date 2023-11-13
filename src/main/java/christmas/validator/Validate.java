package christmas.validator;


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





}
