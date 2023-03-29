import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

  @Test
  void sort() {
    assertEquals(List.of(1, 2, 3, 4), new BubbleSort().sort(List.of(4, 2, 1, 3)));
    assertEquals(List.of(1, 2, 3, 4), new BubbleSort().sort(List.of(4, 3, 2, 1)));
    assertEquals(List.of(1, 2, 3, 4), new BubbleSort().sort(List.of(1, 2, 3, 4)));
    assertEquals(List.of(), new BubbleSort().sort(List.of()));
  }
}