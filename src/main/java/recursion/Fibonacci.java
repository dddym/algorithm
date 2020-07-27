package recursion;

/**
 * @author liuda@baixing.com
 * @date 2020-07-27 11:07
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fabo(6));
    }

    private static int fabo(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fabo(i - 1) + fabo(i - 2);
        }
    }
}
