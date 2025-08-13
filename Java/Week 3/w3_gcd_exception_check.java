import java.util.InputMismatchException;
import java.util.Scanner;

public class w3_gcd_exception_check {

    public static void main(String[] args)
    {
        int n, d; // numerator and devisor

        Scanner userScanner = new Scanner(System.in);// Scanner to capture user input from terminal
        System.out.print("Enter first integer: ");
        n = userGetInt(userScanner); // Ask user for first number
        System.out.print("Enter second integer: ");
        d = userGetInt(userScanner); // Ask user for second number

        System.out.println(n + "/" + d + " : GCD = " + gCD(n, d)); // calculate GCD
        System.out.println(n + "/" + d + " : GCD = " + gCDRecursive(n, d)); // calculate GCD recursively

        userScanner.close(); // Scanner no longer needed, program exit.
    }

    /*
     * Function to find the greatest common devisor of two numbers non-recursively.
     * en.wikipedia.org/wiki/Greatest_common_devisor for reference on Euclid's
     * algorithm.
     */
    public static int gCD(int n, int d)
    {
        int remainder; // temp variable for shifting between devisors
        try
        {
            if (n == d) // if equal, gcd = n = d
            {
                return n;
            } else
            {

                while (d != 0) // loop until divisor found
                {
                    remainder = n % d; // get remainder of division
                    if (remainder != 0) // if there is a remainder
                    {
                        n = d; // shift devisor to numerator
                        d = remainder; // make remainder new devisor
                    } else // if remainder = 0
                    {
                        return d; // return final devisor
                    }
                }
            }
        } catch (java.lang.ArithmeticException e) // if a devide by zero exception occurs
        {
            System.out.println("Cant divide by Zero");
        }
        return n; // return numerator where devisor is zero

    }

    /*
     * Function to find the greated common devisor of two numbers recursively.
     */
    public static int gCDRecursive(int n, int d)
    {
        try
        {
            if (n == d) // if equal, gcd = n = d
            {
                return n;
            } else if (d == 0) // if devisor is zero
            {
                return n;
            } else
            {
                return gCDRecursive(d, n % d); // recursive check with devisor, devided by remainder.
            }
        } catch (java.lang.ArithmeticException e) // if a devide by zero exception occurs
        {
            System.out.println("Cant divide by Zero");
        }
        return d; // Fallback return, should not be used
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
