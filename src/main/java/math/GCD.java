package math;

/**
 * Utility class for determining the greatest common divisor of two integers.
 */
public class GCD {

    /**
     * Returns the greatest common divisor of the integers specified.
     *
     * @param a an argument
     * @param b another argument
     * @return the greatest common divisor of the integers specified
     */
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.abs(a) + Math.abs(b);
        }
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        int c;
        while (a != 0) {
            c = a;
            a = b % a;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.printf("Usage: java %s <int> <int>%n", GCD.class.getName());
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.printf("gcd(%d,%d) = %d\n", a, b, gcd(a, b));
    }

}
