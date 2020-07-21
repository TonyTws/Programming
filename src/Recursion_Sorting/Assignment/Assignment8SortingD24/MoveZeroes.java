package Recursion_Sorting.Assignment.Assignment8SortingD24;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/move-zeroes/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/359484943/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                count++;
                if(count != i+1){
                    swap(nums,i,count-1);
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
