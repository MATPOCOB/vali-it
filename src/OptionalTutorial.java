import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.time.Month.JANUARY;

public class OptionalTutorial {

  class User {
    String name;
    LocalDate birthDate;

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
      new User("Rob"),
      new User("Anna")
  );

  public Optional<User> searchUser(String name) {
    return null;
  }

//  public void printOutUserNameIfPresent(String name) {}
//  public void printOutNotFoundIfNotPresent(String name) {}

//  public Optional<LocalDate> searchUserBirthday(String name) {}
}