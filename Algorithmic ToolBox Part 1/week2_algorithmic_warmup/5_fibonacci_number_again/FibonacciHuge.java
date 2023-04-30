import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long calc_fib(long n, long m) {
        if (n <= 1)
          return n;
    
        long a =0,b=1;
        long c = 2;
        for(long i=2;i<=n;i+=1L){
          c = a+b;
          if(c>m){
            c=c%m;
          }
          a=b;
          b=c;
          if(i%100000L==0L){
            System.out.println("Iteration:"+i);
          }
    
        }
        return c%m;
      }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(calc_fib(n, m));
    }
}

