package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputConverterTest {

  @DisplayName("날짜 입력을 숫자로 반환 - 유효 입력")
  @Test
  void convertDate_validInput() {
    // given
    String input = "11";

    // when
    int result = InputConverter.convertDate(input);

    // then
    int expect = 11;
    assertEquals(result, expect);
  }

  @DisplayName("날짜 입력을 숫자로 반환 - 유효하지 입력")
  @Test
  void convertDate_invalidInput() {
    // given
    String input = "11s";

    // when, then
    assertThrows(IllegalArgumentException.class, () -> InputConverter.convertDate(input));
  }


}