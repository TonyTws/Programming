package Assignment5SortingD21;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://leetcode.com/problems/reverse-pairs/
 * Answer Link
 * https://leetcode.com/submissions/detail/356971562/
 */

public class ReversePairs {
    static int[] temp = new int[10000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(reversePairs(nums));
        }
    }

    private static int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        return solve(nums,0,nums.length-1);

    }

    private static int solve(int[] nums, long start, long end) {
        int count = 0;
        if (start < end) {
            long mid = start + (end - start) / 2;
            count += solve(nums, start, mid);
            count += solve(nums, mid + 1, end);
            count += merge(nums, start, mid, end);
        }
        return count;
    }

    private static long merge(int[] nums, long start, long mid, long end) {
        long count = 0;
        long s1 = start, e1 = mid, s2 = mid + 1, e2 = end;
        long k = s1;
        for (int j = (int) s2; j <= e2; j++) {

            while (k <= e1 && nums[(int)k] <= 2*(long)nums[j]) {
                k++;
            }
            count += e1 - k + 1;
        }

        long index = start;
        while (s1 <= e1 && s2<= e2){
            if(nums[(int)s1] <= nums [(int) s2]){
                temp[(int) index++] = nums[(int) s1++];
            }else{
                temp[(int) index++] = nums[(int) s2++];
            }
        }
        while(s1 <= e1){
            temp[(int) index++] = nums[(int) s1++];
        }
        while(s2<=e2){
            temp[(int) index++] = nums[(int) s2++];
        }
        for (int i = (int) start; i <= end; i++) {
            nums[i] = temp[i];
        }

        return count;
    }
}
