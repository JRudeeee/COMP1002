import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractiveListMenu {
    public static void main(String[] args)
    {
        int mainMenuChoice = 0;
        int subMenuChoice = 0;
        boolean quit = false;
        Scanner userScanner = new Scanner(System.in);
        DSAQueue queue = new DSAQueue();
        DSAStack stack = new DSAStack();
        DSALinkedList list = new DSALinkedList();

        int newValue;
        int repeat;

        while (!quit)
        {
            switch (mainMenuChoice) {
            case 0 -> {
                displayMenu(mainMenuChoice);
                mainMenuChoice = userGetInt(userScanner, 1, 4);
            }
            case 1 -> {
                displayMenu(mainMenuChoice);
                subMenuChoice = userGetInt(userScanner, 1, 5);
                switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Enter a number to store");
                    newValue = userGetInt(userScanner, 0, 255);
                    System.out.println("how many times?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        stack.push(newValue);
                    }
                }
                case 2 -> {
                    System.out.println("how many items to remove?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        if (!stack.isEmpty())
                        {
                            System.out.print(stack.pop() + ", ");
                        } else
                        {
                            System.out.println("Stack is empty");
                        }
                    }
                    System.out.print("\n");
                }
                case 3 -> {
                    if (!stack.isEmpty())
                    {
                        System.out.println(stack.top());
                    } else
                    {
                        System.out.println("Stack is empty");
                    }

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
            case 2 -> {
                displayMenu(mainMenuChoice);
                subMenuChoice = userGetInt(userScanner, 1, 5);
                switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Enter a number to store");
                    newValue = userGetInt(userScanner, 0, 255);
                    System.out.println("how many times?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        queue.enqueue(newValue);
                    }
                }
                case 2 -> {
                    System.out.println("how many items to remove?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        if (!queue.isEmpty())
                        {
                            System.out.print(queue.dequeue() + ", ");
                        } else
                        {
                            System.out.println("Queue is empty");
                        }
                    }
                    System.out.print("\n");
                }
                case 3 -> {
                    if (!queue.isEmpty())
                    {
                        System.out.println(queue.peek());
                    } else
                    {
                        System.out.println("Queue is empty");
                    }

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
            case 3 -> {
                displayMenu(mainMenuChoice);
                subMenuChoice = userGetInt(userScanner, 1, 7);
                switch (subMenuChoice) {
                case 1 -> {
                    System.out.println("Enter a number to store");
                    newValue = userGetInt(userScanner, 0, 255);
                    System.out.println("how many times?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        list.insertFirst(newValue);
                    }
                }
                case 2 -> {
                    System.out.println("Enter a number to store");
                    newValue = userGetInt(userScanner, 0, 255);
                    System.out.println("how many times?");
                    repeat = userGetInt(userScanner, 0, 255);

                    // for (int i = 0; i < repeat; i++)
                    // {
                        
                    // }
                    list.insertLast(newValue);
                }
                case 3 -> {
                    System.out.println("how many items to remove?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        if (!list.isEmpty())
                        {
                            System.out.print(list.removeFirst() + ", ");
                        } else
                        {
                            System.out.println("List is empty");
                        }
                    }
                    System.out.print("\n");
                }
                case 4 -> {
                    System.out.println("how many items to remove?");
                    repeat = userGetInt(userScanner, 0, 255);

                    for (int i = 0; i < repeat; i++)
                    {
                        if (!list.isEmpty())
                        {
                            System.out.print(list.removeLast() + ", ");
                        } else
                        {
                            System.out.println("List is empty");
                        }
                    }
                    System.out.print("\n");
                }
                case 5 -> {
                    if (!list.isEmpty())
                    {
                        while (!list.isEmpty()){
                            System.out.print(list.removeFirst() + ", ");
                        }
                        System.out.println();
                    } else
                    {
                        System.out.println("List is empty");
                    }

                }
                case 6 -> {
                    mainMenuChoice = 0;
                }
                case 7 -> {
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
                    |  Select the mode of operation  |
                    +--------------------------------+
                    | 1 - Stack                      |
                    | 2 - Queue                      |
                    | 3 - List                       |
                    +--------------------------------+
                    | 4 to quit                      |
                    +--------------------------------+\n""");
        }
        case 1 -> {
            System.out.print("""
                    +--------------------------------+
                    | STACK Mode - Select Operation  |
                    +--------------------------------+
                    | 1 - Insert                     |
                    | 2 - Remove                     |
                    | 3 - Display Top                |
                    +--------------------------------+
                    | 4 to go back                   |
                    | 5 to quit                      |
                    +--------------------------------+\n""");
        }
        case 2 -> {
            System.out.print("""
                    +--------------------------------+
                    | QUEUE Mode - Select Operation  |
                    +--------------------------------+
                    | 1 - Insert                     |
                    | 2 - Remove                     |
                    | 3 - Display Front              |
                    +--------------------------------+
                    | 4 to go back                   |
                    | 5 to quit                      |
                    +--------------------------------+\n""");
        }
        case 3 -> {
            System.out.print("""
                    +--------------------------------+
                    |  LIST Mode - Select Operation  |
                    +--------------------------------+
                    | 1 - Insert Front               |
                    | 2 - Insert Last                |
                    | 3 - Remove Front               |
                    | 4 - Remove Last                |
                    | 5 - Display                    |
                    +--------------------------------+
                    | 6 to go back                   |
                    | 7 to quit                      |
                    +--------------------------------+\n""");
        }
        }
    }

    private static int userGetInt(Scanner scanner, int min, int max)
    {
        int userInt = min - 1; // int entered by user, initialised to -1 in case error occurs
        boolean valid = false; // flag to confirm if an integer has been entered
        System.out.print("Enter and integer: ");
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
