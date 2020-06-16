package Assignment4SortingD20;

/**
 * Question Link
 * https://leetcode.com/problems/merge-sorted-array/
 * Answer Link
 * https://leetcode.com/submissions/detail/354430475/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 =0, j1 = m-1, i2 = 0, j2 = n-1;
        int[] temp = new int[m+n];
        int index = i1;
        while (i1 <= j1 && i2 <= j2) {
            if(nums1[i1] <= nums2[i2]){
                temp[index++] = nums1[i1++];
            }else{
                temp[index++] = nums2[i2++];
            }
        }
        while (i1<=j1) {
            temp[index++] = nums1[i1++];
        }
        while (i2<=j2) {
            temp[index++] = nums2[i2++];
        }
//        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }

    }
}
