package GenesisContest4;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i <m ; i++) nums[i] = sc.nextInt();

        if(n == 0) {
            System.out.println(0);
            System.exit(0);
        }
        int[] steps = new int[21];
        for (int i = 0; i <=20; i++) {
            steps[i] = totalWays(i,3);
        }
        int ways = steps[n];
        for (int i = 0; i< nums.length ; i++) {
            ways -= nums[i];
        }
        System.out.println(ways);

    }

    public static int totalWays(int n, int m){
        if (n < 0) return 0;
        if(n == 0) return  1;
        int count =0;
        for (int i = 1; i <= m; i++) {
            count += totalWays(n-i, m);
        }
        return  count;
    }
}
