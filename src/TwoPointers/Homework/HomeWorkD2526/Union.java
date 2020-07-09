package TwoPointers.Homework.HomeWorkD2526;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=44076715ceca9071c6f84a330b173076&pid=701235&user=shankarchakraborty1
 */

public class Union {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt(), n = sc.nextInt();
            int[] nums1 = new int[m];
            for (int i = 0; i < m; i++) nums1[i] = sc.nextInt();
            int[] nums2 = new int[n];
            for (int i = 0; i < n; i++) nums2[i] = sc.nextInt();
            List<Integer> ans= union(nums1,nums2);
            System.out.println(ans);
        }
    }

    private static List<Integer> union(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        if (arr1.length == 0 || arr2.length == 0) return ans;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                int p = arr1[i];
                while (i < arr1.length && arr1[i] == p) i++;
            } else if (arr1[i] > arr2[j]) {
                ans.add(arr2[j]);
                int p = arr2[j];
                while (j < arr2.length && arr2[j] == p) j++;
            } else {
                ans.add( arr1[i]);
                int p = arr1[i];
                while (i < arr1.length && arr1[i] == p) i++;
                while (j < arr2.length && arr2[j] == p) j++;
            }
        }
        while (i < arr1.length) {
            ans.add(arr1[i]);
            int p = arr1[i];
            while (i < arr1.length && arr1[i] == p) i++;
        }
        while (j < arr2.length) {
            ans.add(arr2[j]);
            int p = arr2[j];
            while (j < arr2.length && arr2[j] == p) j++;
        }
        return ans;
    }
}
