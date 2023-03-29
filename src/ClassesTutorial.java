import java.util.List;

public class ClassesTutorial {

  static abstract class Animal {
    public abstract void saySomething();
    public void sleep() {
      System.out.println("zzz sleeping");
    };
  }

  static class Dog extends Animal {
    @Override
    public void saySomething() {
      System.out.println("Bark");
    }
  }

  static class Beagle extends Dog {
    @Override
    public void saySomething() {
      if (Math.random() > 0.5) {
        System.out.println("Yeeeeee");
      } else {
        super.saySomething();
      }
    }
  }

  static class Cat extends Animal {
    @Override
    public void saySomething() {
      System.out.println("Myau");
    }
  }

  static class Elevant extends Animal {

    @Override
    public void saySomething() {
      System.out.println("Frrrr");
    }
  }

  public static void main(String[] args) {
    List<Animal> animals = List.of(new Dog(), new Elevant(), new Beagle(), new Cat());
    animals.forEach(Animal::saySomething);
    animals.forEach(Animal::sleep);
  }
}
