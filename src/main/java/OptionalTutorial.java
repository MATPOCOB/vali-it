import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

public class OptionalTutorial {

  public static class User {
    public final String name;
    public final LocalDate birthDate;

    public User(String name, LocalDate birthDate) {
      this.name = name;
      this.birthDate = birthDate;
    }

    public User(String name) {
      this.name = name;
      this.birthDate = null;
    }
  }

  List<User> users = List.of(
      new User("John", LocalDate.of(2000, JANUARY, 23)),
      new User("Chris"),
      new User("Christina"),
      new User("Madlene"),
      new User("John", LocalDate.of(2001, MARCH, 12)),
      new User("Rob"),
      new User("Anna")
  );

  public Optional<User> searchUser(String name) {
    return null;
  }

  public Map<String, List<LocalDate>> birthdaysByName() {
//    LinkedHashMap<S/tring, List<User>> collect = users.stream()
//        .collect(Collectors.groupingBy(user -> user.name, LinkedHashMap::new, toList()));
//    return collect;
    return null;
  }

//  public void printOutUserNameIfPresent(String name) {}
//  public void printOutNotFoundIfNotPresent(String name) {}

//  public Optional<LocalDate> searchUserBirthday(String name) {}
}