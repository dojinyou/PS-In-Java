package programmers.programmers.private2208.week2.test1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.private2208.week2.test1.DotProduct;

class DotProductTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(new int[]{1, 2, 3, 4},
                                                            new int[]{-3, -1, 0, 2},
                                                            3
                       )),
                       Arguments.of(new ProgrammersTestData(new int[]{-1, 0, 1},
                                                            new int[]{1, 0, -1},
                                                            -2
                       ))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] a;

    private final int[] b;

    private final int results;

    ProgrammersTestData(
        int[] a,
        int[] b,
        int results
    ) {
      this.a = a;
      this.b = b;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new DotProduct();
    int actual = testClass.solution(data.a, data.b);

    assertThat(actual).isEqualTo(data.results);
  }

}
