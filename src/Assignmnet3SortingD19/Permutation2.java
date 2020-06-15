package Assignmnet3SortingD19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question Link
 * https://leetcode.com/problems/permutations-ii/
 * Answer Link
 * https://leetcode.com/submissions/detail/354037586/
 */

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean flag = true;
        List<List<Integer>> res = new ArrayList<>();
        while(flag){
            List<Integer> r = new ArrayList<>();
            for (int num : nums) {
                r.add(num);
            }
            res.add(r);
            flag = Permutation(nums);

        }
        return res;
    }

    private boolean Permutation(int[] nums) {
        int x = -1;
        int n = nums.length;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                x = i;
                break;
            }
        }
        if(x == -1){
            return false;
        }
        int m = x+1;
        for(int i = x+1; i < n; i++){
            if(nums[i] > nums[x]){
                if(nums[m] >= nums[i]) {
                    m = i;
                }
            }
        }
        swap(nums,x,m);
        reverse(nums,x+1);
        return true;

    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i <= j){
            swap(nums,i,j);
            i++;
            j--;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
