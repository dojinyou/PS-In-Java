package problemsolving.programmers.private2208.week2.test2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class TritConvertTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(45, 7)),
          Arguments.of(new ProgrammersTestData(125, 229))
      );
    }
  }

  static class ProgrammersTestData {
    private final int n;

    private final int results;

    ProgrammersTestData(
        int n,
        int results
    ) {
      this.n = n;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new TritConvert();
    int actual = testClass.solution(data.n);

    assertThat(actual).isEqualTo(data.results);
  }

}
