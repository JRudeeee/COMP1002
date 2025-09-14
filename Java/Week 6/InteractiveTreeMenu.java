import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InteractiveTreeMenu {
    public static void main(String[] args)
    {
        int mainMenuChoice = 0;
        int subMenuChoice;
        boolean quit = false;
        Scanner userScanner = new Scanner(System.in);

        DSABinarySearchTree tree = new DSABinarySearchTree();

        int newValue;

        while (!quit)
        {
            switch (mainMenuChoice) {
            case 0 -> {
                displayMenu(mainMenuChoice);
                mainMenuChoice = userGetInt(userScanner, 1, 4);
            }
            case 1 -> {
                System.out.print("Enter a value to store (0-255)\n");
                newValue = userGetInt(userScanner, 0, 255);
                try {
                    tree.insert(String.valueOf(newValue), newValue);
                } catch (IllegalStateException e) {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 2 -> {
                System.out.print("Enter a key to delete (0-255)\n");
                newValue = userGetInt(userScanner, 0, 255);
                try {
                    tree.delete(String.valueOf(newValue));
                } catch (NoSuchElementException e) {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 3 -> {
                displayMenu(mainMenuChoice);
                subMenuChoice = userGetInt(userScanner, 1, 5);
                switch (subMenuChoice) {
                case 1 -> {
                    tree.inorder();
                    mainMenuChoice = 0;
                }
                case 2 -> {
                    tree.preorder();
                    mainMenuChoice = 0;
                }
                case 3 -> {
                    tree.postorder();
                    mainMenuChoice = 0;
                }
                case 4 -> {
                    mainMenuChoice = 0;
                }
                case 5 -> {
                    quit = true;
                    System.out.println("Goodbye!");
                }
                }
            }
            case 4 -> {
                quit = true;
                System.out.println("Goodbye!");
            }
            }

        }
        userScanner.close();
    }

    private static void displayMenu(int menuID)
    {
        switch (menuID) {
        case 0 -> {
            System.out.print("""
                    +--------------------------------+
                    |  Tree Test - Select Operation  |
                    +--------------------------------+
                    | 1 - Add node                   |
                    | 2 - Delete node                |
                    | 3 - Display the tree           |
                    +--------------------------------+
                    | 4 to quit                      |
                    +--------------------------------+\n""");
        }
        case 3 -> {
            System.out.print("""
                    +--------------------------------+
                    |    Select The Display Mode     |
                    +--------------------------------+
                    | 1 - In-Order                   |
                    | 2 - Pre-Order                  |
                    | 3 - Post-Order                 |
                    +--------------------------------+
                    | 4 to go back                   |
                    | 5 to quit                      |
                    +--------------------------------+\n""");
        }
        }
    }

    private static int userGetInt(Scanner scanner, int min, int max)
    {
        int userInt = min - 1; // int entered by user, initialised to -1 in case error occurs
        boolean valid = false; // flag to confirm if an integer has been entered
        System.out.print("Enter an integer: ");
        while (userInt < min || userInt > max) // will loop until the user enters positive or zero int
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
                if (valid && (userInt < min || userInt > max)) // If input is number less than zero
                {
                    System.out.printf("Only enter a number between %d and %d\n", min, max);
                    System.out.print("Enter an integer: ");
                    valid = false; // reset valid flag for next loop
                }
            }
        }
        return userInt; // return user input int
    }

}
