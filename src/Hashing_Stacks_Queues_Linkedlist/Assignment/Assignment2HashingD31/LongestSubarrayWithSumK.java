package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=68cc0ec8c126a7cf116fcf7aad332581&pid=2909&user=shankarchakraborty1
 */
public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solve(nums,k));

        }
    }

    private static int solve(int[] nums,int k) {
        int length = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // for empty prefix sum with it's index
        map.put(0,-1);
        int ps =0;
        for (int i = 0; i < nums.length ; i++) {
            ps += nums[i];
            if(map.containsKey(ps - k)){
                length = Math.max(length, i - map.get(ps-k));
            }
            if(!map.containsKey(ps)){
                map.put(ps,i);
            }
        }

        return length;
    }
}
