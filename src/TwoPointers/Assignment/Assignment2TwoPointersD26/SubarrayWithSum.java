package TwoPointers.Assignment.Assignment2TwoPointersD26;

import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=d0bb3a24db7e86868650d8e8c566ef20&pid=590&user=shankarchakraborty1
 */
public class SubarrayWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            solve(nums,k);
        }
    }

    private static void solve(int[] nums, int sum) {
        int i =0, j =0;
        int curSum = nums[0];
        while(j < nums.length){
            if(curSum == sum){
                System.out.println((i+1)+" "+(j+1));
                return;
            }else if(curSum > sum){
                if( i == j ){
                    i++;
                    j++;
                    if(i < nums.length) {
                        curSum = nums[i];
                    }
                }else{
                    curSum -= nums[i];
                    i++;
                }
            }else{
                j++;
                if(j < nums.length) {
                    curSum += nums[j];
                }
            }
        }

        System.out.println(-1);
    }
}
