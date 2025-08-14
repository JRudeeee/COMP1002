public class w3_base_conversion {
    public static void main(String[] args)
    {
        int num = 0;
        int base = 16;

        System.out.printf("Decimal: %d in base %d: ", num, base);
        StringBuilder reverseResult = new StringBuilder();
        StringBuilder result = new StringBuilder();

        convertBase(num, base, reverseResult, result);

        System.out.printf("%s", result);

        reverseResult.setLength(0);
        result.setLength(0);

        System.out.printf("   %s\n", reverseResult);

        System.out.printf("Recursively - Decimal: %d in base %d: ", num, base);

        decToresultRec(num, base, reverseResult, result);

        System.out.printf("%s", result);

    }

    public static void convertBase(int dec, int base, StringBuilder reverseResult, StringBuilder result)
    {
        int modResult;
        String[] letters = { "A", "B", "C", "D", "E", "F" };
        
        if (dec == 0)
        {
            reverseResult.append(dec);
        }else 
        {
            while (dec > 0)
            {
                modResult = dec % base;

                if (modResult > 9)
                {
                    reverseResult.append(letters[modResult - 10]);
                } else
                {
                    reverseResult.append(dec % base);
                }
                dec = dec / base;

            }
        }
        reverseString(reverseResult, result);
    }

    public static void decToresultRec(int dec, int base, StringBuilder reverseResult, StringBuilder result)
    {
        int modResult;
        String[] letters = { "A", "B", "C", "D", "E", "F" };

        switch (dec) {
        case 0 -> {
            if (reverseResult.isEmpty()){
                reverseResult.append(dec);
            }
            reverseString(reverseResult, result);
        }
        default -> {
            modResult = dec % base;
            if (modResult > 9)
            {
                reverseResult.append(letters[modResult - 10]);
            } else
            {
                reverseResult.append(dec % base);
            }
            decToresultRec(dec / base, base, reverseResult, result);
        }
        }

    }

    public static void reverseString(StringBuilder input, StringBuilder output)
    {
        for (int ii = input.length() - 1; ii >= 0; ii--)
        {
            output.append(input.charAt(ii));
        }
    }
}
