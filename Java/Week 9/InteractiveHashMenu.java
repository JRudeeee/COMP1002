import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InteractiveHashMenu {
    public static void main(String[] args)
    {
        int mainMenuChoice = 0;
        int subMenuChoice;
        boolean quit = false;
        Scanner userScanner = new Scanner(System.in);
        String userString1, userString2;

        DSAHashTable hashTable = new DSAHashTable(10);

        int newValue;

        while (!quit)
        {
            switch (mainMenuChoice) {
            case 0 -> {
                displayMenu(mainMenuChoice);
                mainMenuChoice = userGetInt(userScanner, 1,9);
            }
            case 1 -> { //put
                System.out.println("Enter a key: ");
                userString1 = userScanner.nextLine();
                System.out.println("Enter a value to store: ");
                userString2 = userScanner.nextLine();
                try
                {
                    hashTable.put(userString1, userString2);
                } catch (IllegalStateException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 2 -> { //hasKey
                System.out.println("Enter a key to find: ");
                userString1 = userScanner.nextLine();
                try
                {
                    if(hashTable.hasKey(userString1)){
                        System.out.println(userString1 + " is in hash table.");
                    } else {
                        System.out.println(userString1 + " is not in hash table.");
                    }
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 3 -> { //get
                System.out.println("Enter a key to find: ");
                userString1 = userScanner.nextLine();     
                try
                {
                    if (hashTable.get(userString1) != null){
                        System.out.println("Value stored at key " + userString1 + ": " + (hashTable.get(userString1).toString()));
                    } else {
                        System.out.println("Value is null");
                    }
                    
                } catch (Exception e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 4 -> { //remove
                System.out.println("Enter a key to remove: ");
                userString1 = userScanner.nextLine();
                try
                {
                    hashTable.remove(userString1);
                    System.out.println(userString1 + " has been removed.");
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 5 -> { //display stats
                try
                {
                    System.out.printf("""
                            Hash Table Stats
                            Size        | %d
                            Count       | %d
                            Load Factor | %f
                            \n""", hashTable.getSize(), hashTable.count, hashTable.getLoadFactor());
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 6 -> { // import
                try
                {
                    hashTable.importTable("RandomNames7000.csv");
                    System.out.println("Import Susccesful");
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 7 -> { // export
                try
                {
                    hashTable.export("output.csv");
                    System.out.println("Export Successful");
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
             case 8 -> { // quit
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
                    |  Hash Test - Select Operation  |
                    +--------------------------------+
                    | 1 - put                        |
                    | 2 - hasKey                     |
                    | 3 - get                        |
                    | 4 - remove                     |
                    | 5 - Display stats              |
                    | 6 - Import                     |
                    | 7 - Export                     |
                    +--------------------------------+
                    | 8 to quit                      |
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
                scanner.nextLine();
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
