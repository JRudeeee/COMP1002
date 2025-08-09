public class w3_factorial {

    public static void main(String[] args)
    {
        for (int n = 0; n < 50000; n++)
        {
            System.out.printf("Facorial of %d is %d\n", n, calcNFactorial(n));
        }

        for (int n = 0; n < 50000; n++)
        {
            System.out.printf("Facorial of %d is %d\n", n, calcNFactorialRecursive(n));
        }

    }

    public static long calcNFactorial(int n)
    {
        long nFactorial = 1;
        for (int ii = n; ii >= 2; ii--)
            nFactorial *= ii;
        return nFactorial;
    }

    public static long calcNFactorialRecursive(int n)
    {
        if (n == 0)
            return 1;
        else
            return n * calcNFactorialRecursive(n - 1);
    }
}
