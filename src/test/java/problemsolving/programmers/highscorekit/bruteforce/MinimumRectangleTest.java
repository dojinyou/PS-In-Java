package problemsolving.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class MinimumRectangleTest {

  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(new int[][]{
          {60, 50}, {30, 70}, {60, 30}, {80, 40}
      }, 4000)), Arguments.of(new ProgrammersTestData(new int[][]{
          {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
      }, 120)), Arguments.of(new ProgrammersTestData(new int[][]{
          {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
      }, 133)));
    }
  }

  static class ProgrammersTestData {

    private final int[][] sizes;

    private final int results;

    ProgrammersTestData(
        int[][] sizes,
        int results
    ) {
      this.sizes = sizes;
      this.results = results;
    }

    public int getResults() {
      return results;
    }

    public int[][] getSizes() {
      return sizes;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[][] sizes = data.getSizes();
    int expect = data.getResults();

    var testClass = new MinimumRectangle();
    int actual = testClass.solution(sizes);

    assertThat(actual).isEqualTo(expect);
  }
}
