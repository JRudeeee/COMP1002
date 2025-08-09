public class w3_fibonacci {

    public static void main(String[] args)
    {

        for (int n = 0; n < 200; n++)
        {
            System.out.printf("Fib_%d = %d\n", n, fibonacci(n));

            System.out.printf("Fib_%d = %d\n", n, fibonacciRecursive(n));
        }
    }

    public static long fibonacci(int n)
    {
        switch (n) {
        case 0 -> {
            return 0;
        }
        case 1 -> {
            return 1;
        }
        default -> {
            long fib1 = 0;
            long fib2 = 1;
            long fibResult = 0;

            for (int ii = 2; ii <= n; ii++)
            {
                fibResult = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibResult;
            }

            return fibResult;
        }
        }

    }

    public static long fibonacciRecursive(int n)
    {
        switch (n) {
        case 0 -> {
            return 0;
        }
        case 1 -> {
            return 1;
        }
        default -> {
            long fibResult = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
            return fibResult;
        }
        }

    }

}