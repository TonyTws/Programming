package TwoPointers.Homework.HomeWorkD2526;

/**
 * Question Link
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Answer Link
 * https://leetcode.com/submissions/detail/361201439/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j =1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
