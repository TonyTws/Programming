package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The general idea behind this method is to maintain a variable that keeps track of the prefix sum of all the element. The prefix sum means the sum of all element from index 0 to the current elemtn (inclusive). e.g prefixSum(2) = nums[0] + nums[1] + nums[2]
 *
 * index: 0 1 2
 * nums: [1, 1, 1]
 * prefixSum: 0 1, 2, 3
 * (the reason we have prefix sum of 0 is to handle the edge case when index is 0)
 *
 * Once we have such prefix sum, the sum of any subarray is the difference between the end index - (start index - 1). For instance, the sum of index 1 to 2 is prefixSum[2] - prefixSum[0]. The reason is simple.
 *
 * prefixSu[0] = nums[0]
 * prefixSu[2] = nums[0] + nums[1] + nums[2]
 *
 *
 * Question Link
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/371938287/
 */

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(subarraySum(nums, k));

        }
    }

    private static int subarraySum(int[] nums, int k) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // key is the prefix sum, value is the # of occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        // when index is 0, the prefix sum is 0
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int element : nums) {
            prefixSum += element;
                count += map.get(prefixSum - k);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
