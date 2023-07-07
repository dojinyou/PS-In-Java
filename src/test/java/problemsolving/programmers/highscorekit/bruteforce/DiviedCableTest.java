package problemsolving.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class DiviedCableTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(9,new int[][]{{1, 3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}, 3)),
          Arguments.of(new ProgrammersTestData(4,new int[][]{{1, 2},{2,3},{3,4}}, 0)),
          Arguments.of(new ProgrammersTestData(7,new int[][]{{1, 2},{2,7},{3,7},{3,4},{4,5},{6,7}}, 1))
      );
    }
  }

  static class ProgrammersTestData {
    private final int n;

    private final int[][] wires;

    private final int results;

    ProgrammersTestData(
        int n,
        int[][] wires,
        int results
    ) {
      this.n = n;
      this.wires = wires;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new DiviedCable();
    int actual = testClass.solution(data.n, data.wires);

    assertThat(actual).isEqualTo(data.results);
  }

}
