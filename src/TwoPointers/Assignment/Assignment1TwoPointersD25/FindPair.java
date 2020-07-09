package TwoPointers.Assignment.Assignment1TwoPointersD25;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/find-pair-given-difference/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=be7bb0d58f2286f91593360844e1e37c&pid=2082&user=shankarchakraborty1
 */
public class FindPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(solve(nums,k));
        }
    }

    private static int solve(int[] nums, int k) {
        int i = 0, j = 1;
        while(j < nums.length){
            int num = nums[j] - nums[i];
            if(num == k){
                return 1;
            }else if(num < k){
                j++;
            }else{
                if(j == i+1){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
}
