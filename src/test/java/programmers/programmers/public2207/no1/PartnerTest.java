package programmers.programmers.public2207.no1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.public2207.no1.Partner;

class PartnerTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData("100", "2345", "-1")),
          Arguments.of(new ProgrammersTestData("100", "203045", "0")),
          Arguments.of(new ProgrammersTestData("100", "123450", "10")),
          Arguments.of(new ProgrammersTestData("12321", "42531", "321")),
          Arguments.of(new ProgrammersTestData("5525", "1255", "552"))
      );
    }
  }

  static class ProgrammersTestData {
    private final String X;
    private final String Y;
    private final String result;

    ProgrammersTestData(
        String x,
        String y,
        String result
    ) {
      X = x;
      Y = y;
      this.result = result;
    }

    public String getX() {
      return X;
    }

    public String getY() {
      return Y;
    }

    public String getResult() {
      return result;
    }

  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    String X = data.getX();
    String Y = data.getY();
    String expect = data.getResult();

    var testClass = new Partner();
    String actual = testClass.solution(X, Y);

    assertThat(actual).isEqualTo(expect);
  }

}
