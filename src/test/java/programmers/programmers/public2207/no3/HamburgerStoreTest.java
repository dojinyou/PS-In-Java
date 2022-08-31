package programmers.programmers.public2207.no3;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class HamburgerStoreTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1},2)),
          Arguments.of(new ProgrammersTestData(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2},0))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] ingredient;

    private final int results;

    ProgrammersTestData(
        int[] ingredient,
        int results
    ) {
      this.ingredient = ingredient;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    var testClass = new HamburgerStore();
    int actual = testClass.solution(data.ingredient);

    assertThat(actual).isEqualTo(data.results);
  }

}
