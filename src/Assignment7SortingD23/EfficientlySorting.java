package Assignment7SortingD23;

import java.util.EnumSet;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/efficiently-sorting-number-from-0-to-n2-1/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=6f2c2bc1e395355f18d8ddf2b1324602&pid=1976&user=shankarchakraborty1
 */
class EfficientlySorting
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            countSort(nums, n, 1);
            countSort(nums, n, n);
            printArr(nums, n);
        }
    }

    static void countSort(int[] nums, int n, int exp)
    {
        int[] output = new int[n];
        int[] count = new int[n] ;
        for (int i=0; i < n; i++)
            count[i] = 0;
        for (int i = 0; i < n; i++)
            count[ (nums[i]/exp)%n ]++;

        for (int i = 1; i < n; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--)
        {
            output[count[ (nums[i]/exp)%n] - 1] = nums[i];
            count[(nums[i]/exp)%n]--;
        }

        for (int i = 0; i < n; i++)
            nums[i] = output[i];
    }

    static void printArr(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}


