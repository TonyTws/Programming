package Recursion_Sorting.Assignment.Assignment6SortingD22;

import java.util.ArrayList;
import java.util.List;

/**
 * Questions Link
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Answer Link
 * https://leetcode.com/submissions/detail/357041014/
 */
public class SmallerNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        System.out.println(countSmaller(nums));
    }
    public static List<Integer> countSmaller(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(nums.length == 0) return ans;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i],i};
        }

        int[] count = new int[n];
        solve(0,n-1,count,new int[n][2],arr);
        for(int c: count)
            ans.add(c);
        return ans;
    }

    private static void solve(int start, int end, int[] count, int[][] temp, int[][] nums) {
        if(start < end){
            int mid = start+(end - start)/2;
            solve(start,mid,count,temp,nums);
            solve(mid+1,end,count,temp,nums);
            merge(start,mid,end,count,temp,nums);
        }
    }

    private static void merge(int start, int mid, int end, int[] count, int[][] temp, int[][] nums) {
        int s1 = start, e1 = mid,s2 = mid +1,e2 = end;
        int index = s1;

        while(s1 <= e1 && s2 <= e2){
            if(nums[s1][0] <= nums[s2][0]) {
                count[nums[s1][1]] += s2 - (mid +1);
                temp[index++] = nums[s1++];
            }else{
                temp[index++] = nums[s2++];
            }
        }

        while(s1 <= e1){
            count[nums[s1][1]] += s2 - (mid +1);
            temp[index++] = nums[s1++];
        }
        while( s2 <= e2){
            temp[index++] = nums[s2++];
        }

        for (int i = start; i <= end ; i++) {
            nums[i] = temp[i];
        }
    }
}
