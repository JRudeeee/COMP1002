import java.util.InputMismatchException;
import java.util.Scanner;

public class w3_fibonacci_exception_check {

    public static void main(String[] args)
    {

        Scanner userScanner = new Scanner(System.in); // Scanner to capture user input from terminal
        System.out.print("Enter an integer: ");
        int n = userGetInt(userScanner); // Ask user for number to calculate facotrial

        System.out.printf("Fib_%d = %d\n", n, fibonacci(n));

        System.out.printf("Fib_%d = %d\n", n, fibonacciRecursive(n));

        userScanner.close(); // Scanner no longer needed, program exit.

    }

    /*
     * function to calculate the value of a given number in the fibonacci sequence
     * non-recursively. en.wikipedia.org/wiki/Fibonacci_sequence used for
     * definitions.
     */
    public static long fibonacci(int n)
    {
        long fibResult;
        switch (n) { // depending on the value of being calculated
        case 0 -> { // where initial value is 0
            fibResult = 0;
        }
        case 1 -> { // where initial value is 1
            fibResult = 1;
        }
        default -> { // for any other value of n
            long fib1 = 0; // initialised for n = 2
            long fib2 = 1; // initialised for n = 2
            fibResult = 0; // initilised to 0 in case loop fails

            for (int ii = 2; ii <= n; ii++) // loop from 2 to n
            {
                fibResult = fib1 + fib2; // sum fib n to fib n+1
                fib1 = fib2; // shift value of fib n+1 to fib n
                fib2 = fibResult; // set sum result to new fib n+1
            }

            
        }
        }
        return fibResult; // return fib number
    }

    /*
     * function to calculate the value of a given number in the fibonacci sequence recursively.
     */
    public static long fibonacciRecursive(int n)
    {
        long fibResult;
        switch (n) { // depending on the value of being calculated
        case 0 -> { // where initial value is 0
            fibResult = 0;
        }
        case 1 -> { // where initial value is 1
            fibResult = 1;
        }
        default -> { // for any other value of n
            fibResult = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
            /*
             * recursively find the sum of the number on the fibonacci 
             * sequence. Two recursive calls to find each number.
             */
            
        }
        }
        return fibResult; //return fib number

    }


    /*
     * Function to get an integer input from the user. Checks user input until input
     * is correct to return.
     */
    private static int userGetInt(Scanner scanner)
    {
        int userInt = -1; // int entered by user, initialised to -1 in case error occurs
        boolean valid = false; // flag to confirm if an integer has been entered
        while (userInt < 0) // will loop until the user enters positive or zero int
        {
            try
            {
                userInt = scanner.nextInt(); // get user input
                valid = true; // if user input didn't throw exception, set flag
            } catch (InputMismatchException e) // catch user entered non integer
            {
                System.out.println("Only enter integers!");
                scanner.nextLine(); // shift scanner to allow new input to be read
                System.out.print("Enter an integer: ");
            } finally
            {
                if (valid && userInt < 0) // If input is number less than zero
                {
                    System.out.println("Only enter positive numbers!");
                    System.out.print("Enter an integer: ");
                    valid = false; // reset valid flag for next loop
                }
            }
        }
        return userInt; // return user input int
    }
}