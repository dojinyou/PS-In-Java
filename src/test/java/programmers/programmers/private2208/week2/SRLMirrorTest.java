package programmers.programmers.private2208.week2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.private2208.week2.SRLMirror;

class SRLMirrorTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new String[]{"SL", "LR"}, new int[]{16})),
          Arguments.of(new ProgrammersTestData(new String[]{"S"}, new int[]{1, 1, 1, 1})),
          Arguments.of(new ProgrammersTestData(new String[]{"R", "R"}, new int[]{4, 4}))
      );
    }
  }

  static class ProgrammersTestData {

    private final String[] grid;

    private final int[] results;

    ProgrammersTestData(
        String[] grid,
        int[] results
    ) {
      this.grid = grid;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new SRLMirror();
    int[] actual = testClass.solution(data.grid);

    assertThat(actual).isEqualTo(data.results);
  }

}
