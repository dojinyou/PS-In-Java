package problemsolving.programmers.private2208.week2.test2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class AllCombinationTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{2, 1, 3, 4, 1}, new int[]{2, 3, 4, 5, 6, 7})),
          Arguments.of(new ProgrammersTestData(new int[]{5, 0, 2, 7}, new int[]{2, 5, 7, 9, 12}))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] numbers;

    private final int[] results;

    ProgrammersTestData(
        int[] numbers,
        int[] results
    ) {
      this.numbers = numbers;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new AllCombination();
    int[] actual = testClass.solution(data.numbers);

    assertThat(actual).isEqualTo(data.results);
  }

}
