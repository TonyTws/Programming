package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 *
 * Answer Link
 * https://ideone.com/Ph16Vf
 */
public class LargestSubarraySumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int length = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        // for empty prefix sum with it's index
        map.put(0,-1);
        int ps =0;
        for (int i = 0; i < nums.length ; i++) {
           ps += nums[i];
           if(map.containsKey(ps)){
               length = Math.max(length, i - map.get(ps));
           }else{
               map.put(ps,i);
           }
        }
        return length;
    }
}
