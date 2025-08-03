import java.lang.Math;

public class activity_2 {

    public static void main(String[] args) {
        int n = 9;
        int d = 3;

        System.out.println(n + "/" + d + " : GCD = " + gCD(n, d));
        System.out.println(n + "/" + d + " : GCD = " + gCDRecursive(n, d));
    }

    public static int gCD(int n, int d) {
        int remainder = -1;
        n = Math.abs(n);
        d = Math.abs(d);
        try {
            if (n == d) {
                return n;
            } else {

                while (d != 0) {
                    remainder = n % d;
                    if (remainder != 0) {
                        n = d;
                        d = remainder;
                    }
                }
            }

        } catch (java.lang.ArithmeticException e) {
            System.out.println("Cant divide by Zero");
        } finally {

        }
        return n;

    }

    public static int gCDRecursive(int n, int d) {
        n = Math.abs(n);
        d = Math.abs(d);
        try {
            if (n == d) {
                return n;
            } else if (d == 0) {
                return n;
            } else {
                return gCDRecursive(d, n % d);
            }
        } catch (java.lang.ArithmeticException e) {
            System.out.println("Cant divide by Zero");
        } finally {

        }
        return d;
    }
}
