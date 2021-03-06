package Recursion_Sorting.Assignment.Assignment2SortingD18;

import java.util.Arrays;

/**
 * Question link
 * https://www.geeksforgeeks.org/sum-manhattan-distances-pairs-points/
 *
 * Answer Link
 * https://ideone.com/2Y9JI0
 */

public class SumOfManhattanDistances {
    public static void main(String[] args) {
        int[] x = new int[]{-1, 1, 3, 2};
        int[] y = new int[]{5, 6, 5, 3};
        System.out.println(manhattan(x,y));
    }

    private static int manhattan(int[] x, int[] y) {
        return sumOfDistance(x) + sumOfDistance(y);
    }

    private static int sumOfDistance(int[] nums) {
        Arrays.sort(nums);

        int sum =0,ans =0;
        for (int i = 0; i < nums.length; i++) {
            ans += (nums[i] * i) - sum;
            sum += nums[i];
        }
        return ans;
    }
}
