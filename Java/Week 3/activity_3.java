public class activity_3 {
    public static void main(String[] args) {
        int num = 5;

        System.out.printf("Decimal: %d in binary: ", num);
        StringBuilder reversedBin = new StringBuilder();
        StringBuilder bin = new StringBuilder();

        decToBin(num, reversedBin, bin);

        System.out.printf("%s", bin);

        reversedBin.setLength(0);
        bin.setLength(0);

        System.out.printf("   %s\n", reversedBin);

        System.out.printf("Recursively - Decimal: %d in binary: ", num);

        decToBinRec(num, reversedBin, bin);

        System.out.printf("%s", bin);

    }

    public static void decToBin(int dec, StringBuilder reversedBin, StringBuilder bin) {
        while (dec > 0) {
            if (dec == 2) {
                reversedBin.append("10");
                dec = 0;
                reverseString(reversedBin, bin);
            } else if (dec == 1) {
                reversedBin.append("1");
                dec = 0;
                reverseString(reversedBin, bin);
            } else {
                reversedBin.append(dec % 2);
                dec = dec / 2;
            }
        }
    }

    public static void decToBinRec(int dec, StringBuilder reversedBin, StringBuilder bin) {
        if (dec == 2) {
            reversedBin.append("10");
            reverseString(reversedBin, bin);
        } else if (dec == 1) {
            reversedBin.append("1");
            reverseString(reversedBin, bin);
        } else {
            reversedBin.append(dec % 2);
            decToBinRec(dec / 2, reversedBin, bin);
        }

    }

    public static void reverseString(StringBuilder input, StringBuilder output) {
        for (int ii = input.length() - 1; ii >= 0; ii--) {
            output.append(input.charAt(ii));
        }
    }
}
