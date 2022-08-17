package programmers.programmers.highscorekit.sort;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class BiggestNumberTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{6, 10, 2}, "6210")),
          Arguments.of(new ProgrammersTestData(new int[]{3, 30, 34, 5, 9}, "9534330")),
          Arguments.of(new ProgrammersTestData(new int[]{0, 0, 0, 0}, "0")),
          Arguments.of(new ProgrammersTestData(new int[]{1, 10, 100, 1000}, "1101001000")),
          Arguments.of(new ProgrammersTestData(new int[]{48, 484}, "48484")),
          Arguments.of(new ProgrammersTestData(new int[]{232,23}, "23232")),
          Arguments.of(new ProgrammersTestData(new int[]{212,21}, "21221")),
          Arguments.of(new ProgrammersTestData(new int[]{70,0,0,0,0}, "700000")),
          Arguments.of(new ProgrammersTestData(new int[]{104, 1}, "1104")),
          Arguments.of(new ProgrammersTestData(new int[]{30, 3021}, "303021"))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] numbers;

    private final String result;

    ProgrammersTestData(
        int[] numbers,
        String result
    ) {
      this.numbers = numbers;
      this.result = result;
    }

    public int[] getNumbers() {
      return numbers;
    }

    public String getResult() {
      return result;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[] numbers = data.getNumbers();
    String expect = data.getResult();

    var testClass = new BiggestNumber();
    String actual = testClass.solution(numbers);

    assertThat(actual).isEqualTo(expect);
  }
}
