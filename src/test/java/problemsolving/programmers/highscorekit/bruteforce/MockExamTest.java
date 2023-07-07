package problemsolving.programmers.highscorekit.bruteforce;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class MockExamTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{1, 2, 3, 4, 5}, new int[]{1})),
          Arguments.of(new ProgrammersTestData(new int[]{1, 3, 2, 4, 2}, new int[]{1, 2, 3}))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] answers;

    private final int[] results;

    ProgrammersTestData(
        int[] answers,
        int[] results
    ) {
      this.answers = answers;
      this.results = results;
    }

    public int[] getAnswers() {
      return answers;
    }

    public int[] getResults() {
      return results;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[] answers = data.getAnswers();
    int[] expect = data.getResults();

    var testClass = new MockExam();
    int[] actual = testClass.solution(answers);

    assertThat(actual).isEqualTo(expect);
  }
}
