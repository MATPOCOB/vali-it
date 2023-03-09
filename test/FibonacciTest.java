import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

  @Test
  void calculate() {
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
    assertEquals(0, new Fibonacci().calculate(1));
    assertEquals(1, new Fibonacci().calculate(2));
    assertEquals(1, new Fibonacci().calculate(3));
    assertEquals(2, new Fibonacci().calculate(4));
    assertEquals(3, new Fibonacci().calculate(5));
    assertEquals(5, new Fibonacci().calculate(6));
    assertEquals(8, new Fibonacci().calculate(7));
    assertEquals(13, new Fibonacci().calculate(8));
    assertEquals(144, new Fibonacci().calculate(13));
  }


  @ParameterizedTest
  @ArgumentsSource(FibonacciArgumentsProvider.class)
  void calculate_parametrized(int i, int expected) {
    assertEquals(expected, new Fibonacci().calculate(i));
  }

  static class FibonacciArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
          Arguments.of(1, 0),
          Arguments.of(2, 1),
          Arguments.of(3, 1),
          Arguments.of(4, 2),
          Arguments.of(5, 3),
          Arguments.of(6, 5),
          Arguments.of(7, 8),
          Arguments.of(8, 13),
          Arguments.of(13, 144)
      );
    }
  }
}