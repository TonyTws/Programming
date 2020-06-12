package LeetCodeJune.Week2;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }
    public static boolean isPowerOfTwo(int n) {
        System.out.println(n);
        if(n == 0) return true;
        return isPowerOfTwo(n/2);
        hello

    }
}
