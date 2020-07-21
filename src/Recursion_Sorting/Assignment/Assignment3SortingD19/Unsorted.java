package Recursion_Sorting.Assignment.Assignment3SortingD19;

import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/length-unsorted-subarray/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=f70bb50979d25acd748d9831445f67dc&pid=573&user=shankarchakraborty1
 */

public class Unsorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  t= sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int i =0, j = nums.length-1;
            for (int k = 0; k < n-1; k++) {
                if(nums[k] <= nums[k+1]){
                    i++;
                }else{
                    break;
                }
            }

            for (int k = n -1; k >=1; k--) {
                if(nums[k-1] <= nums[k]){
                    j--;
                }else{
                    break;
                }
            }
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int k = i; k <=j; k++) {
                min = Math.min(min,nums[k]);
                max = Math.max(max,nums[k]);
            }
            for (int k = i; k >0 ; k--) {
                if(min < nums[k-1]){
                    i--;
                }
            }
            for (int k = j; k < n-1 ; k++) {
                if(max > nums[k+1]){
                    j++;
                }
            }
            System.out.println(i +" "+ j);
        }
    }
}
