package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question link
 * https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=5a9f7cf822bd48c058864791401a5418&pid=700245&user=shankarchakraborty1
 */

public class LargestSubarray01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solve( nums,n));
        }
    }

    private static int solve(int[] arr,int n) {
        int ans  =0,pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
               arr[i] = -1;
            }
        }
        map.put(0,-1);
        for (int i = 0; i <arr.length ; i++) {
            pre += arr[i];
            if(map.containsKey(pre)){
                ans = Math.max(ans, i - map.get(pre));
            }else{
                map.put(pre,i);
            }
        }

        return ans;
    }
}
