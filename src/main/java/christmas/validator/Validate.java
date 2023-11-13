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

  // 날짜의 범위 검증
  public void validateDateNumberRange(int date) {
    if(date < 1 || date > 31) {
      throw new IllegalArgumentException();
    }
  }





}
