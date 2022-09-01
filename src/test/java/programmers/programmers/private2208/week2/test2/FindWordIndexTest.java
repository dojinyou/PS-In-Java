package programmers.programmers.private2208.week2.test2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FindWordIndexTest {
static class DataArguments implements ArgumentsProvider {

  @Override
  public Stream<Arguments> provideArguments(ExtensionContext context) {
    return Stream.of(
        Arguments.of(new ProgrammersTestData("AAAAE", 6)),
        Arguments.of(new ProgrammersTestData("AAAE", 10))
    );
  }
}
  static class ProgrammersTestData {

    private final String word;

    private final int results;

    ProgrammersTestData(
        String word,
        int results
    ) {
      this.word = word;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new FindWordIndex();
    int actual = testClass.solution(data.word);

    assertThat(actual).isEqualTo(data.results);
  }
}
