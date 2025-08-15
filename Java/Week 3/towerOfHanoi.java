import java.util.InputMismatchException;
import java.util.Scanner;

public class towerOfHanoi {

    public static int[] numTowers = { 0, 0, 0 };
    public static int recursionLevel = 1;
    public static int numMoves = 0;

    public static void main(String[] args)
    {
        int n;
        int src;
        int dest;
        int failures = 0;
        
        Scanner userScanner = new Scanner(System.in);
        System.out.print("How many towers are there? (1-12) : ");
        n = userGetInt(userScanner);
        while (n < 1 || n > 12){
            failures++;
            if(failures > 2){
                System.err.println("Can't follow instructions?! 3 it is!");
                n = 3;
            } else{
                System.out.println("Please enter a number between 1 and 12!");
                System.out.print("How many towers are there? (1-12) : ");
                n = userGetInt(userScanner);
            }
        }
        failures = 0;

        System.out.print("Which position are the towers in to start? (1,2,3) : ");
        src = userGetInt(userScanner);
        while (src < 1 || src > 3){
            failures++;
            if(failures > 2){
                System.err.println("Can't follow instructions?! 1 it is!");
                src = 1;
            } else{
                System.out.println("Please enter 1, 2 or 3!");
                System.out.print("Which position are the towers in to start? (1,2,3) : ");
                src = userGetInt(userScanner);
            }
        }
        failures = 0;

        System.out.print("Which position are the towers moving to? (1,2,3) : ");
        dest = userGetInt(userScanner);
        while (dest < 1 || dest > 3){
            failures++;
            if(failures > 2){
                System.err.println("Can't follow instructions?! 3 it is!");
                dest = 3;
            } else{
                System.out.println("Please enter 1, 2 or 3!");
                System.out.print("Which position are the towers moving to? (1,2,3) : ");
                dest = userGetInt(userScanner);
            }
        }
        
        numTowers[src - 1] = n;

        System.out.printf("towers(%d, %d, %d)\n", n, src, dest);
 
        if (src != dest){
            towers(n, src, dest);
        }

        System.out.printf("... # There are %d moves for this problem.\n", numMoves);
        
        userScanner.close();
    }

    public static void towers(int n, int src, int dest)
    {
        int tmp;

        if (n == 1)
        {
            System.out.printf("    ".repeat(recursionLevel - 1) + "Recursion Level=%d\n", recursionLevel);
            System.out.printf("    ".repeat(recursionLevel - 1) + "Moving Disk %d from Source %d to Destination %d\n",
                    n, src, dest);
            System.out.printf("    ".repeat(recursionLevel - 1) + "n=%d, src=%d, dest=%d\n\n",
                    n, src, dest);
            moveDisc(src, dest);
            recursionLevel -= 1;
        } else
        {
            recursionLevel += 1;
            tmp = 6 - src - dest;
            towers(n - 1, src, tmp);

            System.out.printf("    ".repeat(recursionLevel - 1) + "Recursion Level=%d\n", recursionLevel);
            System.out.printf("    ".repeat(recursionLevel - 1) + "Moving Disk %d from Source %d to Destination %d\n",
                    n, src, dest);
            System.out.printf("    ".repeat(recursionLevel - 1) + "n=%d, src=%d, dest=%d\n\n",
                    n, src, dest);

            moveDisc(src, dest);

            towers(n - 1, tmp, dest);
        }
    }

    public static void moveDisc(int src, int dest)
    {
        numMoves++;
        if (numTowers[src - 1] > 0)
        {
            numTowers[src - 1] -= 1;

            numTowers[dest - 1] += 1;
        } else
        {
            System.out.printf("    ".repeat(recursionLevel - 1) + "Error, can't move nothing!");
        }

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


