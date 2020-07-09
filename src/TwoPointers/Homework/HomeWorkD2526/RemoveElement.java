package TwoPointers.Homework.HomeWorkD2526;


/**
 * Question Link
 * https://leetcode.com/problems/remove-element/
 * Answer Link
 * https://leetcode.com/submissions/detail/361197298/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0; i < nums.length; i++){

            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
