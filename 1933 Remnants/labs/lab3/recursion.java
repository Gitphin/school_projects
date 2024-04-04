import java.lang.Math;

public class recursion {

  public static int rec(int num) {
    int temp = num;
    int i = 0;
    if(num == 0) {
      return 0;
    }
    while(num > 9) {
      num /= 10;
      i += 1;
    }
    return num + 10 * rec(temp % (int)Math.pow(10,i));
  }

  public static int ite(int num) {
    int temp = 0;
    while(num != 0) {
      temp = temp * 10 + num % 10;
      num /= 10;
    }
    return temp;
  }
  public static int recfib(int num) {
    if(num == 0) {
      return 0
    }
    if(num == 1) {
      return 1
    }
    if(num == 2) {
      return 1
    }
    return recfib(num-2) + num(num-1)
  }
  public static void main(String[] args) {
    System.out.println(rec(1273))
    System.out.println(ite(1273))
    System.out.println(recfib(12))
  }
}
