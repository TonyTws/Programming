package Extra.TCS;

import java.util.Scanner;

public class Factorial {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(factorial(nums[i]));
        }
    }

    private static long factorial(int num) {
        if (num == 0 || num == 1)
            return 1;
        return num * factorial(num - 1);
    }

}
