package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment1HashingD30;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=c23a5d20f141e335a79d346fc66dddde&pid=2051&user=shankarchakraborty1
 */

public class SubarrayWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++)
                nums[i] = sc.nextInt();
            System.out.println(solve(nums));
        }
        System.exit(0);
    }

    private static String solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        map.put(0, 1);
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                return "Yes";
            } else {
                map.put(num, 1);
            }
        }
        return "No";
    }
}
