import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int calc_fib(int n) {
        if (n <= 1)
          return n;
    
        int a =0,b=1;
        int c = 2;
        for(int i=2;i<=n;i++){
          c = a+b;
          if(c>10){
            c=c%10;
          }
          a=b;
          b=c;
          
        }
        return c%10;
      }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = calc_fib(n);
        System.out.println(c);
    }
}

