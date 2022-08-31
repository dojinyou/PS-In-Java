package programmers.programmers.private2208.week2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.private2208.week2.AbsoluteAndSign;

class AbsoluteAndSignTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{4, 7, 12}, new boolean[]{true, false, true}, 9)),
          Arguments.of(new ProgrammersTestData(new int[]{1, 2, 3}, new boolean[]{false, false, true}, 0)));
    }
  }

  static class ProgrammersTestData {
    private final int[] absolutes;

    private final boolean[] signs;

    private final int results;

    ProgrammersTestData(
        int[] absolutes,
        boolean[] signs,
        int results
    ) {
      this.absolutes = absolutes;
      this.signs = signs;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    var testClass = new AbsoluteAndSign();
    int actual = testClass.solution(data.absolutes, data.signs);

    assertThat(actual).isEqualTo(data.results);
  }
}
