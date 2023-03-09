import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

  @Test
  void calculate_0() {
    assertEquals(0, new Factorial().calculate(0));
  }

  @Test
  void calculate_1() {
    assertEquals(1, new Factorial().calculate(1));
  }

  @Test
  void calculate_2() {
    assertEquals(2, new Factorial().calculate(2));
  }

  @Test
  void calculate_3() {
    assertEquals(6, new Factorial().calculate(3));
  }

  @Test
  void calculate_10() {
    assertEquals(3628800, new Factorial().calculateLong(10));
  }

  @Test
  void calculate_12() {
    assertEquals(479001600, new Factorial().calculate(12));
  }

  @Test
  void calculate_13() { //max int 2_147_483_648
    assertEquals(6_227_020_800L, new Factorial().calculateLong(13));
  }

  @Test
  void calculate_100() {
    assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
        new Factorial().calculateBigInteger(100));
  }
}