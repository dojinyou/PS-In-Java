package problemsolving.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class CarpetTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(10, 2, new int[]{4, 3})),
          Arguments.of(new ProgrammersTestData(8, 1, new int[]{3, 3})),
          Arguments.of(new ProgrammersTestData(24, 24, new int[]{8, 6}))
      );
    }
  }

  static class ProgrammersTestData {
    private final int brown;
    private final int yellow;

    private final int[] results;

    ProgrammersTestData(
        int brown,
        int yellow,
        int[] results
    ) {
      this.brown = brown;
      this.yellow = yellow;
      this.results = results;
    }

    public int getBrown() {
      return brown;
    }

    public int[] getResults() {
      return results;
    }

    public int getYellow() {
      return yellow;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int brown = data.getBrown();
    int yellow = data.getYellow();
    int[] expect = data.getResults();

    var testClass = new Carpet();
    int[] actual = testClass.solution(brown, yellow);

    assertThat(actual).isEqualTo(expect);
  }

}
