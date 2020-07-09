package TwoPointers.Assignment.Assignment1TwoPointersD25;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 *
 * Answer Link
 * https://ideone.com/PmltgR
 */

public class PairCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(solve(nums, k));
        }
    }

    private static int solve(int[] nums, int k) {
        int count = 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            int num = nums[j] - nums[i];
            if (num == k) {
                if (nums[i] != nums[j]) {
                    int c1 = 0, c2 = 0;
                    int p = nums[i], q = nums[j];
                    while (i < nums.length && nums[i] == p) {
                        c1++;
                        i++;
                    }
                    while (j < nums.length && nums[j] == q) {
                        c2++;
                        j++;
                    }
                    count += c1 * c2;
                } else {
                    int p = nums[i], c = 0;
                    while (nums[i] == p) {
                        i++;
                        c++;
                    }
                    j = i + 1;
                    count += nCr(c, 2);
                }
            } else if (num > k) {
                if (j == i + 1) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            } else {
                j++;
            }
        }
        return count;
    }

    private static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    private static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
