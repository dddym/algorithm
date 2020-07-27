package recursion;

/**
 * @author liuda@baixing.com
 * @date 2020-07-27 11:01
 */
public class Disk {

    /**
     * 递归问题的汉诺塔问题 hn = 2^n - 1
     * 要明白中间过程，就是B柱
     * @param n
     * @param A
     * @param B
     * @param C
     */
    private static void move(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "--->" + C);
        } else {
            move(n-1, A, C, B);
            System.out.println(A + "--->" + C);
            move(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        move(4, 'a', 'b', 'c');
    }
}
