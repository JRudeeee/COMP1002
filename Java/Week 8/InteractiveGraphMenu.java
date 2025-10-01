import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InteractiveGraphMenu {
    public static void main(String[] args)
    {
        int mainMenuChoice = 0;
        int subMenuChoice;
        boolean quit = false;
        Scanner userScanner = new Scanner(System.in);
        String userString1, userString2;

        DSAGraph graph = new DSAGraph();

        int newValue;

        while (!quit)
        {
            switch (mainMenuChoice) {
            case 0 -> {
                displayMenu(mainMenuChoice);
                mainMenuChoice = userGetInt(userScanner, 1, 10);
            }
            case 1 -> { //add vertex
                System.out.println("Enter a node lable:");
                try
                {
                    graph.addVertex(userScanner.next(), null);
                } catch (IllegalStateException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 2 -> { //delete vertex
                System.out.println("Enter a node lable:");
                try
                {
                    graph.deleteVertex(userScanner.next());
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;
            }
            case 3 -> { //add edge
                
                System.out.println("Enter first node lable:");
                userString1 = userScanner.next();
                System.out.println("Enter second node lable:");
                userString2 = userScanner.next();                
                try
                {
                    graph.addEdge(userString1, userString2);
                } catch (Exception e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 4 -> { //delete edge
                System.out.println("Enter first node lable:");
                userString1 = userScanner.next();
                System.out.println("Enter second node lable:");
                userString2 = userScanner.next();                
                try
                {
                    graph.deleteEdge(userString1, userString2);
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 5 -> { //display as list
                try
                {
                    graph.displayAsList();
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 6 -> { // display as matrix
                try
                {
                    graph.displayAsMatrix();
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 7 -> { // breadth first search
                try
                {
                    graph.breadthFirstSeatch();
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 8 -> { // depth first seatch
                try
                {
                    graph.depthFirstSearch();
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 9 -> { // display stats
                try
                {
                    System.out.printf("Vertex Count: %d\n", graph.getVertexCount());
                    System.out.printf("Edge Count: %d\n", graph.getEdgeCount());
                } catch (NoSuchElementException e)
                {
                    System.out.println(e);
                }
                mainMenuChoice = 0;

            }
            case 10 -> { // quit
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
                    | 3 - Add edge                   |
                    | 4 - Delete edge                |
                    | 5 - DisplayAsList              |
                    | 6 - DisplayAsMatrix            |
                    | 7 - Breadth first search       |
                    | 8 - Depth first search         |
                    | 9 - Display stats              |
                    +--------------------------------+
                    | 10 to quit                     |
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
