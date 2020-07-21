package Recursion_Sorting.Assignment.Assignment8SortingD24;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/quick-sort/1
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=fec9b94303521c86b370192a9d8cf802&pid=700151&user=shankarchakraborty1
 */

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Sort(arr, 0, n - 1);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int par = partition(arr, low, high);
            Sort(arr, low, par - 1);
            Sort(arr, par + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low + 1, j = high;
        while (i <= j) {

            while (i <= high && arr[i] <= arr[low]) {
                i++;
            }
            while (j >= low && arr[j] > arr[low]) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
