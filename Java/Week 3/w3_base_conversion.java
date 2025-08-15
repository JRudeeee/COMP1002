public class w3_base_conversion {
    public static void main(String[] args)
    {
        int num = 0; // number to convert
        int base = 16; // base to convert to

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
    }

    /*
     * Function to convert an integer of base 10 to and base 2-16 recursively
     */
    public static void decToresultRec(int dec, int base, StringBuilder reverseResult, StringBuilder result)
    {
        int modResult;//holder variable for the modulo operation output
        // Array of letters to cover base 11-16 numbers
        String[] letters = { "A", "B", "C", "D", "E", "F" };

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
}
