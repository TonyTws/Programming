package TwoPointers.Homework.HomeWorkD2526;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/361927007/
 */
public class RemoveDuplicatesII {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int n = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, n)));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <=2) return nums.length;
        int i =0,j=0;
        while ( i < nums.length){
            if(i+1 < nums.length && nums[i] == nums[i+1]) {
                nums[j++] = nums[i];
                nums[j++] = nums[i+1];
            }else{
                nums[j++] = nums[i];
            }
            int p = nums[i];
            while (i < nums.length && nums[i] == p) i++;
        }
        return j;
    }
}
