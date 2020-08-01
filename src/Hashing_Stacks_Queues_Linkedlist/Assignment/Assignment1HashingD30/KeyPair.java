package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment1HashingD30;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/key-pair/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=41e782ec78e2d550da7923aa7f8a48af&pid=552&user=shankarchakraborty1
 */

public class KeyPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++)
                nums[i] = sc.nextInt();
            System.out.println(solve(nums,sum));
        }
        System.exit(0);
    }

    private static String solve(int[] nums, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(sum - num)) {
                return "Yes";
            } else {
                map.put(num, 1);
            }
        }
        return "No";
    }
}
