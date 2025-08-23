public class w3_gcd {

    public static void main(String[] args)
    {
        int n = 0;
        int d = 1000;

        System.out.println(n + "/" + d + " : GCD = " + gCD(n, d));
        System.out.println(n + "/" + d + " : GCD = " + gCDRecursive(n, d));
    }

    /*
     * Function to find the greatest common devisor of two numbers non-recursively.
     * en.wikipedia.org/wiki/Greatest_common_devisor for reference on Euclid's
     * algorithm.
     */
    public static int gCD(int n, int d)
    {
        int result;
        int remainder; // temp variable for shifting between devisors
        if (n == d) // if equal, gcd = n = d
        {
            result = n;
        } else
        {

            result = n; // return numerator where devisor is zero
            while (d != 0) // loop until divisor found
            {
                remainder = n % d; // get remainder of division
                if (remainder != 0) // if there is a remainder
                {
                    n = d; // shift devisor to numerator
                    d = remainder; // make remainder new devisor
                } else // if remainder = 0
                {
                    result = d; // return final devisor
                    d = 0; // exit loop
                }
            }
            
            
        }
        return result;
    }

    /*
     * Function to find the greated common devisor of two numbers recursively.
     */
    public static int gCDRecursive(int n, int d)
    {
        int result;
        if (n == d) // if equal, gcd = n = d
        {
            result = n;
        } else if (d == 0) // if devisor is zero
        {
            result = n;
        } else
        {
            result = gCDRecursive(d, n % d); // recursive check with devisor, devided by remainder.
        }
    return result;
    }
}
