import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int gcd(int a, int b) {

    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    if(a==1||b==1){
      return 1;
    }
    if (a == b) {
      return a;
    } else if (a > b) {
      return gcd(a %b, b);
    } else {
      return gcd(a, b% a);
    }
  }

  private static long lcm(int a, int b) {
    long product =(long)a *(long)b;
    return product / (long)gcd(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
