public class w3_factorial {

    public static void main(String[] args)
    {
        for (int n = 0; n < 5; n++) // loop through non-recursive factorial calculation
        {
            System.out.printf("Facorial of %d is %d\n", n, calcNFactorial(n));
        }

        for (int n = 0; n < 5; n++) // Loop through values to see where the recursive throws exception
        {
            System.out.printf("Facorial of %d is %d\n", n, calcNFactorialRecursive(n));
        }

    }

    /*
     * Function to calculate the factorial in a non-recursive manner.
     * en.wikipedia.org/wiki/Factorial used confirm definitions.
     */
    public static long calcNFactorial(int n)
    {
        long nFactorial = 1; // Factorial of 0, 1 == 1

        // if n is 2 or greater, calculate the factorial
        for (int ii = n; ii >= 2; ii--)
            nFactorial *= ii;
        return nFactorial; // return the result
    }

    /*
     * Function to calculate the factorial recursively.
     */
    public static long calcNFactorialRecursive(int n)
    {
        if (n == 0) // final recursive call when n=0
            return 1;
        else // return product of n and subsequent recursive calls.
            return n * calcNFactorialRecursive(n - 1);
    }
}
