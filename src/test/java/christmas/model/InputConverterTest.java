package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashMap;
import java.util.Map;

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
  @ValueSource(strings = {"11s", "", "123"})
  @ParameterizedTest
  void convertDate_invalidInput(String input) {
    // when, then
    assertThrows(IllegalArgumentException.class, () -> InputConverter.convertDate(input));
  }

  @DisplayName("메뉴 입력값 변환 - 유효한 입력")
  @Test
  void convertOrder_validInput() {
    // given
    String input = "양송이수프-1,제로콜라-1";

    // when
    Map<String, Integer> result = InputConverter.convertOrder(input);

    // then
    Map<String, Integer> expect = new LinkedHashMap<>(Map.of(
            "양송이수프",1,
            "제로콜라",1
    ));
    assertEquals(result, expect);
  }

  @DisplayName("메뉴 입력값 반환 - 유효하지 않은 입력")
  @ValueSource(strings = {"", "양송이수프,제로콜라", "양송이수프", "양송-1,제로-2"})
  @ParameterizedTest
  void convertOrder_invalidInput(String input) {
    assertThrows(IllegalArgumentException.class, () -> InputConverter.convertOrder(input));
  }


}