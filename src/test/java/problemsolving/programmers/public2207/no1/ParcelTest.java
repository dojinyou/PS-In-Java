package problemsolving.programmers.public2207.no1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class ParcelTest {

  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(new int[]{4, 3, 1, 2, 5}, 2)),
          Arguments.of(new ProgrammersTestData(new int[]{5, 4, 3, 2, 1}, 5)),
          Arguments.of(new ProgrammersTestData(new int[]{1, 4, 3, 2, 5}, 5)),
          Arguments.of(new ProgrammersTestData(new int[]{1, 3, 5, 4, 2}, 5))
      );
    }
  }

  static class ProgrammersTestData {
    private final int[] order;

    private final int result;

    ProgrammersTestData(
        int[] order,
        int result
    ) {
      this.order = order;
      this.result = result;
    }

    public int[] getOrder() {

      return order;
    }

    public int getResult() {
      return result;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    int[] order = data.getOrder();
    int expect = data.getResult();

    var testClass = new Parcel();
    int actual = testClass.solution(order);

    assertThat(actual).isEqualTo(expect);
  }
}
