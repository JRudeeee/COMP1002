public class w3_fibonacci {

    public static void main(String[] args)
    {

        for (int n = 0; n < 200; n++) // loop through values of N to test functions. The recursive becomes incredibly slow before it throws an exception.
        {
            System.out.printf("Fib_%d = %d\n", n, fibonacci(n));

            System.out.printf("Fib_%d = %d\n", n, fibonacciRecursive(n));
        }
    }

    /*
     * function to calculate the value of a given number in the fibonacci sequence non-recursively.
     * en.wikipedia.org/wiki/Fibonacci_sequence used for definitions.
     */
    public static long fibonacci(int n)
    {
        switch (n) { // depending on the value of being calculated
        case 0 -> { // where initial value is 0
            return 0;
        }
        case 1 -> { // where initial value is 1
            return 1;
        }
        default -> { // for any other value of n
            long fib1 = 0; // initialised for n = 2
            long fib2 = 1; // initialised for n = 2
            long fibResult = 0; // initilised to 0 in case loop fails

            for (int ii = 2; ii <= n; ii++) // loop from 2 to n
            {
                fibResult = fib1 + fib2; // sum fib n to fib n+1
                fib1 = fib2; // shift value of fib n+1 to fib n
                fib2 = fibResult; // set sum result to new fib n+1
            }

            return fibResult; // return fib number
        }
        }
    }

    /*
     * function to calculate the value of a given number in the fibonacci sequence recursively.
     */
    public static long fibonacciRecursive(int n)
    {
        switch (n) { // depending on the value of being calculated
        case 0 -> { // where initial value is 0
            return 0;
        }
        case 1 -> { // where initial value is 1
            return 1;
        }
        default -> { // for any other value of n
            long fibResult = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
            /*
             * recursively find the sum of the number on the fibonacci 
             * sequence. Two recursive calls to find each number.
             */
            return fibResult; //return fib number
        }
        }

    }

}