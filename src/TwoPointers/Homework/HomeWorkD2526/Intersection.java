package TwoPointers.Homework.HomeWorkD2526;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/361851656/
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        if(nums1.length == 0 || nums2.length == 0) return ans;
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans[index++] = nums1[i];
                int p = nums1[i];
                while (i < nums1.length && nums1[i] == p) i++;
                while (j < nums2.length && nums2[j] == p) j++;
            }
        }
        return Arrays.copyOf(ans,index);
    }
}
