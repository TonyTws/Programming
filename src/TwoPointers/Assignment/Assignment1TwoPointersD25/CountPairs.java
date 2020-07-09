package TwoPointers.Assignment.Assignment1TwoPointersD25;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://www.geeksforgeeks.org/count-pairs-with-given-sum-set-2/
 *
 * Answer Link
 * https://ideone.com/8587Yj
 */
public class CountPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(solve(nums, k));
        }
    }

    private static int solve(int[] nums, int k) {
        int count =0;
        int i =0, j = nums.length-1;
        while(i < j){
            int num = nums[i]+nums[j];
            if (num < k){
                i++;
            }else if(num > k){
                j--;
            }else{
                if(nums[i] == nums[j]){
                    count += nCr(j-i+1,2);
                    break;
                }else {
                    int c1 = 0, c2 = 0;
                    int p = nums[i], q = nums[j];
                    while (nums[i] == p) {
                        i++;
                        c1++;
                    }
                    while(nums[j] == q){
                        j--;
                        c2++;
                    }
                    count += c1*c2;
                }
            }
        }
        return count;
    }

    private static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) * fact(n - r));
    }
    private static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

}
