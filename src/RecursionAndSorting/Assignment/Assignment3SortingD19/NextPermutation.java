package RecursionAndSorting.Assignment.Assignment3SortingD19;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/next-permutation/
 * Answer Link
 * https://leetcode.com/submissions/detail/354025454/
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int currIdx = i;
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        i = nums.length - 1;
        while (i >= currIdx && nums[i] <= nums[currIdx]) {
            i--;
        }
        swap(nums, currIdx, i);
        Arrays.sort(nums, currIdx + 1, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
