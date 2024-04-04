import java.util.Scanner;

public class gpa {

  public static void main(String[] args) {
    double a = 0;
    double b = 0;

    System.out.println("Enter grades");
    Scanner myScanner = new Scanner(System.in);

    String input = myScanner.nextLine();
    Scanner stringScanner = new Scanner(input);

    while(stringScanner.hasNext()) {

      String inputs = stringScanner.next();
      int num = stringScanner.nextInt();

      if(inputs.equals("a")) {
        b += (num * 4);
      }
      if(inputs.equals("a-")) {
        b += (num * 3.7);
      }
      if(inputs.equals("b+")) {
        b += (num * 3.3);
      }
      if(inputs.equals("b")) {
        b += (num * 3);
      }
      if(inputs.equals("b-")) {
        b += (num * 2.7);
      }
      if(inputs.equals("c+")) {
        b += (num * 2.3);
      }
      if(inputs.equals("c")) {
        b += (num * 2);
      }
      if(inputs.equals("c-")) {
        b += (num * 1.7);
      }
      if(inputs.equals("d+")) {
        b += (num * 1.3);
      }
      if(inputs.equals("d")) {
        b += (num * 1);
      }
      if(inputs.equals("f")) {
        b += (num * 0);
      }

      a += num;
}
  System.out.println("Your GPA is: " + (b / a));
  }
}
