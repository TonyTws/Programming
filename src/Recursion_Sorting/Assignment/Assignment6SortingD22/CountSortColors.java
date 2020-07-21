package Recursion_Sorting.Assignment.Assignment6SortingD22;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/sort-colors/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/358185387/
 */

public class CountSortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int range = max + 1;
        int n = nums.length;
        int[] freq = new int[range];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        for (int i = freq.length -1; i >0 ; i--) {
            freq[i-1] += freq[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[n - freq[nums[i]]] = nums[i];
            freq[nums[i]]--;
        }
        System.arraycopy(ans, 0, nums, 0, n);

    }
}
