package christmas.model;


import christmas.validator.Validate;

/**
 * 입력값을 원하는 형태로 변환
 */
public class InputConverter {

  private final Validate validate = new Validate();

  public int convertDate(String input) {
    validate.validateNumber(input);
    int date = Integer.parseInt(input);
    validate.validateDateNumberRange(date);
    return date;
  }



}
