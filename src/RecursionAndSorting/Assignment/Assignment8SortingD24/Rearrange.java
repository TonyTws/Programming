package RecursionAndSorting.Assignment.Assignment8SortingD24;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
 *
 * Answer Link
 * https://ideone.com/129Owc
 */

public class Rearrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        solve(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void solve(int[] nums, int low, int high) {
        while (low <= high) {
            while (low <= high && nums[low] >= 0) {
                low++;
            }
            while (high >= low && nums[high] < 0) {
                high--;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
