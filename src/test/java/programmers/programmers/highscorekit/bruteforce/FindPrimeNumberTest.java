package programmers.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FindPrimeNumberTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData("17", 3)),
          Arguments.of(new ProgrammersTestData("011", 2))
      );
    }
  }

  static class ProgrammersTestData {
    private final String numbers;

    private final int result;

    ProgrammersTestData(
        String numbers,
        int result
    ) {
      this.numbers = numbers;
      this.result = result;
    }

    public String getNumbers() {
      return numbers;
    }

    public int getResult() {
      return result;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  @DisplayName("프로그래머스 테스트케이스")
  void test(ProgrammersTestData data) {
    String numbers = data.getNumbers();
    int expect = data.getResult();

    var testClass = new FindPrimeNumber();
    int actual = testClass.solution(numbers);

    assertThat(actual).isEqualTo(expect);
  }

}
