import java.util.Scanner;

//Task 1:
//Write a program that takes in a string and prints out all the words in backwards order
//- reverse the letters in words as well
//- make possible to specify individually what to reverse
//e.g. String transform(  String input,
//                        boolean reverseWordsOrderInSentence,
//                        boolean reverseLettersOrderInWords);

//Task 2:
//    Generate a random number 1 to 100,
//    ask the user to guess the number
//    and print if inserted number is higher,
//    lower or equal to the number.
//
//    Ask the question until user has entered "exit"
//
//    Hint: Math.random()

public class StandardInOut {

  public static void main(String[] args) {
    System.out.println("What is your name?");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.next();

    for (int i = 0; i < name.length(); i++) {
      System.out.println(name.charAt(i));
    }
  }
}
