package problemsolving.programmers.public2207.no3;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class AddedCokeTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(2,1,20,19)),
          Arguments.of(new ProgrammersTestData(3,1,20,9))
      );
    }
  }

  static class ProgrammersTestData {
    private final int a;

    private final int b;

    private final int c;

    private final int results;

    ProgrammersTestData(
        int a,
        int b,
        int c,
        int results
    ) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.results = results;
    }

    public int getA() {
      return a;
    }

    public int getB() {
      return b;
    }

    public int getC() {
      return c;
    }

    public int getResults() {
      return results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int a = data.getA();
    int b = data.getB();
    int c = data.getC();
    int expect = data.getResults();

    var testClass = new AddedCoke();
    int actual = testClass.solution(a, b, c);

    assertThat(actual).isEqualTo(expect);
  }

}
