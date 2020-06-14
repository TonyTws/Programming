package Assignment2Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/maximum-index/0
 */


public class MaximumIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(nums[i], i);
            }

            Arrays.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.element - o2.element;
                }
            });

            int ans = Integer.MIN_VALUE;
            int max = pairs[n - 1].index;
            for (int i = n - 2; i >= 0; i--) {
                ans = Math.max(ans, max - pairs[i].index);
                max = Math.max(max, pairs[i].index);
            }

            System.out.println((ans == Integer.MIN_VALUE) ? 0 : ans);

        }
    }

}

class Pair {
    int element;
    int index;

    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }

    @Override
    public String toString() {
        return "{" + element + " " + index + "}";
    }
}