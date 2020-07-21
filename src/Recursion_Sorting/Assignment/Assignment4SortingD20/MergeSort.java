package Recursion_Sorting.Assignment.Assignment4SortingD20;

import java.util.Arrays;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/merge-sort/1
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=5cfb160d2cc9c64d42a12baecc8b8a2a&pid=700150&user=shankarchakraborty1
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{10 ,9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    static void mergeSort(int arr[], int l, int r) {
        if (l < r)   {
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int arr[], int l, int m, int r)
    {
//        System.out.println(Arrays.toString(arr));
        int i1 = l, j1 = m, i2 = m+1, j2 = r;

        int[] temp = new int[arr.length];
        int index = i1;
        while (i1 <= j1 && i2 <= j2) {
            if(arr[i1] <= arr[i2]){
                temp[index++] = arr[i1++];
            }else{
                temp[index++] = arr[i2++];
            }
        }
        while (i1<=j1) {
            temp[index++] = arr[i1++];
        }
        while (i2<=j2) {
            temp[index++] = arr[i2++];
        }
//        System.out.println(Arrays.toString(temp));
        for (int i = l; i <= r; i++) {
            arr[i] = temp[i];
        }
    }
}
