public class Fibonacci {
  int calculate(int i) {
    if (i == 1) return 0;

    int prev = 0;
    int cur = 1;
    for (int j = 2; j < i; j++) {
      int tmp = cur;
      cur = cur + prev;
      prev = tmp;
    }
    return cur;
  }
}
