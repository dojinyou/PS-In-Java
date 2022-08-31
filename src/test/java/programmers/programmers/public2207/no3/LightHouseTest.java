package programmers.programmers.public2207.no3;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class LightHouseTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(8, new int[][]{
          {1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}
      }, 2)), Arguments.of(new ProgrammersTestData(10, new int[][]{
          {4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}
      }, 3)));
    }
  }

  static class ProgrammersTestData {
    private final int n;

    private final int[][] lighthouse;

    private final int results;

    ProgrammersTestData(
        int n,
        int[][] lighthouse,
        int results
    ) {
      this.n = n;
      this.lighthouse = lighthouse;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new LightHouse();
    int actual = testClass.solution(data.n, data.lighthouse);

    assertThat(actual).isEqualTo(data.results);
  }

}
