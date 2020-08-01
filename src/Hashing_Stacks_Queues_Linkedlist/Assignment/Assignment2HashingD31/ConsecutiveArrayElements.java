package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/consecutive-array-elements/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=bad47ee1f5c10bd5df83821c7f65f6bf&pid=2296&user=shankarchakraborty1
 */

public class ConsecutiveArrayElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solve( nums));
        }
    }

    private static String solve(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            min = Math.min(min,num);
        }

        for (int num = min; num <= min + arr.length -1 ; num++) {
            if(map.containsKey(num) ){
                if(map.get(num) > 1){
                    return "No";
                }
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
