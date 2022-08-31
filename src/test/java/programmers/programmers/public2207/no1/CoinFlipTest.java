package programmers.programmers.public2207.no1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.public2207.no1.CoinFlip;

class CoinFlipTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(
              new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}},
              new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}},5)),
          Arguments.of(new ProgrammersTestData(
              new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
              new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 0, 0}}, -1))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[][] beginning;

    private final int[][] target;

    private final int result;

    ProgrammersTestData(
        int[][] beginning,
        int[][] target,
        int result
    ) {
      this.beginning = beginning;
      this.target = target;
      this.result = result;
    }

    public int[][] getBeginning() {
      return beginning;
    }

    public int[][] getTarget() {
      return target;
    }

    public int getResult() {
      return result;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[][] beginning = data.getBeginning();
    int[][] target = data.getTarget();
    int expect = data.getResult();

    var testClass = new CoinFlip();
    int actual = testClass.solution(beginning, target);

    assertThat(actual).isEqualTo(expect);
  }

}
