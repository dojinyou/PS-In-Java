package problemsolving.programmers.public2207.no3;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class NightMovementTechniquesTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(
                           10,
                           new int[][]{{3, 4}, {5, 8}},
                           new int[][]{{2, 5}, {4, 3}},
                           8
                       )),
                       Arguments.of(new ProgrammersTestData(
                           12,
                           new int[][]{{7, 8}, {4, 6}, {11,10}},
                           new int[][]{{2, 2}, {2, 4}, {3,3}},
                           12
                       ))
      );
    }
  }

  static class ProgrammersTestData {
    private final int distance;

    private final int[][] scope;

    private final int[][] times;

    private final int results;

    ProgrammersTestData(
        int distance,
        int[][] scope,
        int[][] times,
        int results
    ) {
      this.distance = distance;
      this.scope = scope;
      this.times = times;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new NightMovementTechniques();
    int actual = testClass.solution(data.distance, data.scope, data.times);

    assertThat(actual).isEqualTo(data.results);
  }

}
