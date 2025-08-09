public class w3_factorial_exception_check {
    public static void main(String[] args)
    {
        try
        {
            int n = 20;

            long facorial = calcNFactorial(n);
            if (facorial < 1)
            {
                System.err.println("Factorial of " + n + " exceeds size of Long\n");
            } else
            {
                System.out.printf("Facorial of %d is %d\n", n, facorial);
            }
            facorial = calcNFactorialRecursive(n);
            if (facorial < 1)
            {
                System.err.println("Factorial of " + n + " exceeds size of Long\n");
            } else
            {
                System.out.printf("Recursive Factorial of %d is %d\n", n, facorial);
            }

        } catch (StackOverflowError e)
        {
            System.out.println("Error, Stack Overflow\n");
        } catch (Exception e)
        {
            System.out.println("some number");
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
