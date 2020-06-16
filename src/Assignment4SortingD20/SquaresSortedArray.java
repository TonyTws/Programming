package Assignment4SortingD20;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/354415735/
 */

public class SquaresSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, -1,0, 3, 10};
        int[] ans = sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] sortedSquares(int[] A) {
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                k = i;
                break;
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        return merge(k-1, 0, k, A.length - 1, A);

    }

    private static int[] merge(int i1, int j1, int i2, int j2, int[] nums) {
        int[] temp = new int[nums.length];
//        System.out.println(i1+" "+ j1+" "+i2+" "+j2);
        int index = 0;
        while (i1 >= j1 && i2 <= j2) {
//            System.out.println(i1+" "+i2);
            if(nums[i1] <= nums[i2]){
                temp[index++] = nums[i1--];
            }else{
                temp[index++] = nums[i2++];
            }
        }
        while (i1>=j1) {
            temp[index++] = nums[i1--];
        }
        while (i2<=j2) {
            temp[index++] = nums[i2++];
        }
        return temp;

    }
}
