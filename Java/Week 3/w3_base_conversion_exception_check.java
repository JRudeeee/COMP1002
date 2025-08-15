import java.util.InputMismatchException;
import java.util.Scanner;

public class w3_base_conversion_exception_check {
    public static void main(String[] args)
    {
        int num; // number to convert
        int base; // base to convert to

        Scanner userScanner = new Scanner(System.in); // Scanner to capture user input from terminal
        System.out.print("Enter a decimal number to convert: ");
        num = userGetInt(userScanner); // Get user input for number to convert

        System.out.print("Enter a base to convert to between 2-16: ");
        base = userGetInt(userScanner); // Get user input for base to covert to
        while (base < 2 || base > 16){ // Loop until user inputs base between 2 and 16
            System.out.print("Please enter a base between 2-16: "); 
            base = userGetInt(userScanner); //get user input for base to convert again
        }
        


        System.out.printf("Decimal: %d in base %d: ", num, base);
        //some bases are not integers so output will be a string
        StringBuilder reverseResult = new StringBuilder(); 
        StringBuilder result = new StringBuilder();

        // convert to base non-recursive
        convertBase(num, base, reverseResult, result);

        System.out.printf("%s\n", result);

        //reset the strong builders
        reverseResult.setLength(0);
        result.setLength(0);


        System.out.printf("Recursively - Decimal: %d in base %d: ", num, base);

        // convert to base recursively
        decToresultRec(num, base, reverseResult, result);

        System.out.printf("%s", result);

        userScanner.close(); // Scanner no longer needed, program exit.

    }

    /*
     * Function to convert an integer of base 10 to any base 2-16
     * non-recursively
     * https://en.wikipedia.org/wiki/Positional_notation#Base_conversion
     * used for reference.
     */
    public static void convertBase(int dec, int base, StringBuilder reverseResult, StringBuilder result)
    {
        int modResult; //holder variable for the modulo operation output
        // Array of letters to cover base 11-16 numbers
        String[] letters = { "A", "B", "C", "D", "E", "F" };
        try{
            if (dec == 0){ // Check if user entered zero
                reverseResult.append(dec); //We still need to append zero for output to occur
            }
            while (dec > 0) // Loop until base is converted in reverse order
            {
                modResult = dec % base; // Find remainder for builder

                if (modResult > 9) //if remainder higher than 9, base is higher than 10
                {
                    reverseResult.append(letters[modResult - 10]); //add letter from string array to stringbuilder
                } else
                {
                    reverseResult.append(dec % base); //add remainder to string builder
                }
                dec = dec / base; // prepare decimal for next loop

            }
            reverseString(reverseResult, result); // reverse the string to create correct number.
        } catch (Exception e){
            System.out.println("Oh no, we broke something in convertBase");
            System.out.print(e);
        }
    }

    /*
     * Function to convert an integer of base 10 to and base 2-16 recursively
     */
    public static void decToresultRec(int dec, int base, StringBuilder reverseResult, StringBuilder result)
    {
        int modResult;//holder variable for the modulo operation output
        // Array of letters to cover base 11-16 numbers
        String[] letters = { "A", "B", "C", "D", "E", "F" };

        try
        {
            switch (dec) { // depending on current value of number
            case 0 -> { // where current number is zero
                if (reverseResult.isEmpty()) // if user entered zero, string builder will be empty
                {
                    reverseResult.append(dec); // append the zero for correct output
                }
                reverseString(reverseResult, result); // reverse the string to create correct number
            }
            default -> { // where current number is not zero
                modResult = dec % base; // Find remainder for builder
                if (modResult > 9) //if remainder higher than 9, base is higher than 10
                {
                    reverseResult.append(letters[modResult - 10]); //add letter from string array to stringbuilder
                } else
                {
                    reverseResult.append(dec % base); //add remainder to string builder
                }
                decToresultRec(dec / base, base, reverseResult, result); // recurse function with new dec value
            }
            }
        } catch (Exception e) {
            System.out.println("Oh no, we broke something in convertBase");
            System.out.print(e);

        }
    }

    /*
     * Function to reverse the string built during conversion, this will produce
     * the correct ordered output.
     */
    public static void reverseString(StringBuilder input, StringBuilder output)
    {
        for (int ii = input.length() - 1; ii >= 0; ii--) // loop through from end of string to start of string
        {
            output.append(input.charAt(ii)); // append character to new string
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
