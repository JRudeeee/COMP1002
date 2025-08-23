import java.util.InputMismatchException;
import java.util.Scanner;

public class w3_factorial_exception_check {
    public static void main(String[] args)
    {
        Scanner userScanner = new Scanner(System.in); // Scanner to capture user input from terminal
        System.out.print("Enter an integer: ");
        int n = userGetInt(userScanner); // Ask user for number to calculate facotrial

        try
        {
            long facorial = calcNFactorial(n); // Use Long to store result as factorials get big quick
            if (facorial < 1) // zero value, factorial exceeds Long.
            {
                System.err.println("Factorial of " + n + " exceeds size of Long\n");
            } else // display result
            {
                System.out.printf("Facorial of %d is %d\n", n, facorial);
            }
            facorial = calcNFactorialRecursive(n);
            if (facorial < 1) // zero value, factorial exceeds Long.
            {
                //System.err.println("Factorial of " + n + " exceeds size of Long\n");
                System.out.printf("%d", facorial);
            } else // display result
            {
                System.out.printf("Recursive Factorial of %d is %d\n", n, facorial);
            }

        } catch (StackOverflowError e) // Recursive operation has overflowed stack
        {
            System.out.println("Error, Stack Overflow\n");
        } catch (Exception e) // Any other exceptions
        {
            System.out.println("Some other error.");
        }

        userScanner.close(); // Scanner no longer needed, program exit.

    }

    /*
     * Function to calculate the factorial in a non-recursive manner.
     * en.wikipedia.org/wiki/Factorial used confirm definitions.
     */
    public static long calcNFactorial(int n)
    {
        long nFactorial = 1; // Factorial of 0, 1 == 1

        // if n is 2 or greater, calculate the factorial
        for (int ii = n; ii >= 2; ii--)
        {
            nFactorial *= ii;
        }
        return nFactorial; // return the result
    }

    /*
     * Function to calculate the factorial recursively.
     */
    public static long calcNFactorialRecursive(int n)
    {
        long result;
        if (n == 0)
        { // final recursive call when n=0
            result = 1;
        }else
        { // return product of n and subsequent recursive calls.
            result = n * calcNFactorialRecursive(n - 1);
        }
        return result;
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
