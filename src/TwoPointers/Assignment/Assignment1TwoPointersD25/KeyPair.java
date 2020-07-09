package TwoPointers.Assignment.Assignment1TwoPointersD25;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/key-pair/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=255b4c5c8f2a9e3e9f8c61e84182916c&pid=552&user=shankarchakraborty1
 */
public class KeyPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(solve(nums,k));
        }
    }

    private static String solve(int[] nums, int k) {
        int i =0, j = nums.length -1;
        while(i < j){
            int num = nums[i] + nums[j];
            if(num == k){
                return "Yes";
            }else if( num < k){
                i++;
            }else{
                j--;
            }
        }
        return "No";
    }
}
