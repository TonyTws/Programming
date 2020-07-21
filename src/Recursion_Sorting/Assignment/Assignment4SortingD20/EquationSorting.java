package Recursion_Sorting.Assignment.Assignment4SortingD20;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation/0
 * Answer Link
 * https://ideone.com/erpIvv
 */

public class EquationSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t-- > 0)) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i <n ; i++) {
                int num = sc.nextInt();
                nums[i] = (int)(A*Math.pow(num,2) + B*num + C);
            }
            int[] ans = sorted(nums,A,B);
            System.out.println(Arrays.toString(ans));
        }
    }

    public static int[] sorted(int[] arr,int A,int B) {
        int k = -B/(2*A);
        if(A>0) {
            return merge(k , 0, k+1, arr.length - 1, arr);
        }else{
            return merge(arr.length-1, k+1,0,k,arr);
        }

    }

    private static int[] merge(int i1, int j1, int i2, int j2, int[] nums) {
        int[] temp = new int[nums.length];
//        System.out.println(i1+" "+ j1+" "+i2+" "+j2);
        int index = 0;
        while (i1 >= j1 && i2 <= j2) {
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
