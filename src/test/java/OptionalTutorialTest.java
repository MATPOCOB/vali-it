import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalTutorialTest {

  @Test
  void birthdaysByName() {
    assertEquals(Map.of("John", List.of(
          LocalDate.of(2000, JANUARY, 23),
          LocalDate.of(2001, MARCH, 12)
        )),
        new OptionalTutorial().birthdaysByName());
  }
}