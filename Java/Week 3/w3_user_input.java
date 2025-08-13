
import java.util.InputMismatchException;
import java.util.Scanner;

public class w3_user_input {

    public static void main(String[] args)
    {
        int someNumber;
        Scanner userScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        someNumber = userGetInt(userScanner);

        System.out.printf("Entered number: %d\n", someNumber);
        System.out.print("Enter an integer: ");
        someNumber = userGetInt(userScanner);

        System.out.printf("Entered number: %d\n", someNumber);

        userScanner.close();

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
