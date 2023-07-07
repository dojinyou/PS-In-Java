package problemsolving.programmers.highscorekit.sort;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class NumberOfKTest {

  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(new int[]{1, 5, 2, 6, 3, 7, 4},
                                                            new int[][]{
                                                                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
                                                            },
                                                            new int[]{5, 6, 3}
      )));
    }
  }

  static class ProgrammersTestData {
    private final int[] array;

    private final int[][] commands;

    private final int[] results;

    ProgrammersTestData(
        int[] array,
        int[][] commands,
        int[] results
    ) {
      this.array = array;
      this.commands = commands;
      this.results = results;
    }

    public int[] getArray() {
      return array;
    }

    public int[] getResults() {
      return results;
    }

    public int[][] getCommands() {
      return commands;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[] array = data.getArray();
    int[][] commands = data.getCommands();
    int[] expect = data.getResults();

    var testClass = new NumberOfK();
    int[] actual = testClass.solution(array, commands);

    assertThat(actual).isEqualTo(expect);
  }

}
