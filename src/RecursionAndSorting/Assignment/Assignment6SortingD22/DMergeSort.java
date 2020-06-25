package RecursionAndSorting.Assignment.Assignment6SortingD22;

import java.util.Scanner;

/**
 * Question Link
 * https://codeforces.com/contest/873/problem/D
 *
 * Answer Link
 * https://codeforces.com/contest/873/submission/84889884
 */

public class DMergeSort {
    static int count = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        if (k % 2 == 0 || k >=2*n) {
            System.out.println("-1");
        }else {
            mergeSort(k, nums, 0, n);

            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }

    private static void mergeSort(int k, int[] nums, int start, int end) {
        if(count==k || start==end-1)
            return;

        int mid = start+(end-start)/2;
        swap(nums,mid-1,mid);
        count+=2;
        mergeSort(k,nums,start,mid);
        mergeSort(k,nums,mid,end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
