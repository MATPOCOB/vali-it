import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Factorial {
  public int calculate(int i) {
    if (i == 0) return 0;
    int result = 1;
    for (int j = 1; j <= i; j++) {
      result *= j;
    }
    return result;
  }

  public long calculateLong(int i) {
    if (i == 0) return 0;
    long result = 1;
    for (int j = 1; j <= i; j++) {
      result *= j;
    }
    return result;
  }

  public BigInteger calculateBigInteger(int i) {
    if (i == 0) return ZERO;

    BigInteger result = ONE;
    for (int j = 1; j <= i; j++) {
      result = result.multiply(BigInteger.valueOf(j));
    }
    return result;
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      System.out.println(i+"! = " + new Factorial().calculateBigInteger(i));
    }
  }
}
