package programmers.programmers.highscorekit.sort;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class HIndexTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{3, 0, 6, 1, 5}, 3)),
          Arguments.of(new ProgrammersTestData(new int[]{10, 9, 4, 1, 1}, 3)),
          Arguments.of(new ProgrammersTestData(new int[]{0, 1}, 1)),
          Arguments.of(new ProgrammersTestData(new int[]{0, 0, 1, 1}, 1)),
          Arguments.of(new ProgrammersTestData(new int[]{10, 11, 12, 13}, 4)),
          Arguments.of(new ProgrammersTestData(new int[]{4, 4, 4, 5, 0, 1, 2, 3}, 4)),
          Arguments.of(new ProgrammersTestData(new int[]{4, 4, 4}, 3)),
          Arguments.of(new ProgrammersTestData(new int[]{6, 6, 6, 6, 6, 1}, 5)),
          Arguments.of(new ProgrammersTestData(new int[]{12, 11, 10, 9, 8, 1}, 5))
      );

    }
  }

  static class ProgrammersTestData {
    private final int[] citations;

    private final int result;

    ProgrammersTestData(
        int[] citations,
        int result
    ) {
      this.citations = citations;
      this.result = result;
    }

    public int[] getCitations() {
      return citations;
    }

    public int getResult() {
      return result;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[] citations = data.getCitations();
    int expect = data.getResult();

    var testClass = new HIndex();
    int actual = testClass.solution(citations);

    assertThat(actual).isEqualTo(expect);
  }

}
