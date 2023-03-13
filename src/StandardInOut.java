import java.util.Scanner;

//Write a program that takes in a string and prints out all the words in backwards order
//- reverse the letters in words as well
//- make possible to specify individually what to reverse
//e.g. String transform(  String input,
//                        boolean reverseWordsOrderInSentence,
//                        boolean reverseLettersOrderInWords);

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
