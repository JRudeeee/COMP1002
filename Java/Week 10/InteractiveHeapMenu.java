import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InteractiveHeapMenu {
    public static void main(String[] args)
    {
        int mainMenuChoice = 0;
        int subMenuChoice;
        boolean quit = false;
        Scanner userScanner = new Scanner(System.in);
        String userString1, userString2;

        DSAHeap heap = new DSAHeap(10);

        int newValue;

        while (!quit)
        {
            switch (mainMenuChoice) {
            case 0 -> {
                displayMenu(mainMenuChoice);
                mainMenuChoice = userGetInt(userScanner, 1,7);
            }
            case 1 -> { // add
                System.out.println("Enter a priority: ");
                newValue = userGetInt(userScanner, 0, 100);
                System.out.println("Enter a value to store: ");
                userString1 = userScanner.nextLine();
                try
                {
                    heap.add(newValue, userString1);
                } catch (IllegalStateException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 2 -> { // remove
                System.out.println("Removing Element");
                try
                {
                    DSAHeapEntry temp = heap.remove();
                    System.out.printf("""
                            Priority : %d
                            Value    : %s
                            \n""", temp.getPriority(), temp.getValue().toString());

                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 3 -> { // display heap
                heap.display();
                mainMenuChoice = 0;

            }
            case 4 -> { //display stats
                try
                {
                    System.out.printf("""
                            Heap Stats
                            Count       | %d
                            \n""", heap.getCount());
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 5 -> { // import
                try
                {
                    heap.importTable("E:\\Important Documents\\University\\Curtin Uni\\2025\\Semester 2\\COMP1002\\Java\\Week 10\\RandomNames7000.csv");
                    System.out.println("Import Susccesful");
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 6 -> { // export
                try
                {
                    heap.export("E:\\Important Documents\\University\\Curtin Uni\\2025\\Semester 2\\COMP1002\\Java\\Week 10\\output.csv");
                    System.out.println("Export Successful");
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
             case 7 -> { // quit
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
                    |  Heap Test - Select Operation  |
                    +--------------------------------+
                    | 1 - Add                        |
                    | 2 - Remove                     |
                    | 3 - Display heap               |
                    | 4 - Display stats              |
                    | 5 - Import                     |
                    | 6 - Export                     |
                    +--------------------------------+
                    | 7 to quit                      |
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
