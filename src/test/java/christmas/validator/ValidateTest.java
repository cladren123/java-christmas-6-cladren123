package christmas.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

  @DisplayName("입력값이 숫자인지 검증 - 옳은 입력")
  @ValueSource(strings = {"999", "0", "-123"})
  @ParameterizedTest
  void validateNumber_validNumber(String input) {
    assertDoesNotThrow(() -> Validate.validateNumber(input));
  }

  @DisplayName("입력값이 숫자인지 검증 - 예외 입력")
  @ValueSource(strings = {"a", "10c", "c111"})
  @ParameterizedTest
  void validateNumber_invalidNumber(String input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validateNumber(input));
  }


  @DisplayName("입력값이 1~31인지 검증 - 옳은 입력")
  @ValueSource(ints = {1, 11, 31})
  @ParameterizedTest
  void validateDateNumberRange_validNumber(int input) {
    assertDoesNotThrow(() -> Validate.validateDateNumberRange(input));
  }

  @DisplayName("입력값이 1~31인지 검증 - 예외 입력")
  @ValueSource(ints = {-1, 0, 32, 999})
  @ParameterizedTest
  void validateDateNumberRange_invalidNumber(int input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validateDateNumberRange(input));
  }

  @Test
  void validateMenu() {
  }

  @Test
  void validateMenuNumberRange() {
  }

  @Test
  void validateMenuDuplicated() {
  }

  @Test
  void validateMenuHaveNumber() {
  }

  @Test
  void validateMenuOnlyBeverage() {
  }

  @Test
  void validateMenuMaximum() {
  }
}