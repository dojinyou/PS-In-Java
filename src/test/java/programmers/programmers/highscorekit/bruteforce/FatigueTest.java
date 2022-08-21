package programmers.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FatigueTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(
          80,
          new int[][]{
              {80, 20},
              {50, 40},
              {30, 10}
          },
          3
      )));
    }
  }

  static class ProgrammersTestData {
    private final int k;

    private final int[][] dungeons;

    private final int result;

    ProgrammersTestData(
        int k,
        int[][] dungeons,
        int result
    ) {
      this.k = k;
      this.dungeons = dungeons;
      this.result = result;
    }

    public int getK() {
      return k;
    }

    public int getResult() {
      return result;
    }

    public int[][] getDungeons() {
      return dungeons;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int k = data.getK();
    int[][] dungeons = data.getDungeons();
    int expect = data.getResult();

    var testClass = new Fatigue();
    int actual = testClass.solution(k, dungeons);

    assertThat(actual).isEqualTo(expect);
  }

}
