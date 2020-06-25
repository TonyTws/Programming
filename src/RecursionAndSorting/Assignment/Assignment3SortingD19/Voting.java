package RecursionAndSorting.Assignment.Assignment3SortingD19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question Link
 * https://www.codechef.com/MARCH18B/problems/MINVOTE
 * Answer Link
 * https://ideone.com/Tq6j3x
 */
public class Voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int[] pref = new int[n];
            pref[0] = nums[0];
            for (int i = 1; i < n; i++) {
                pref[i] = nums[i] + pref[i - 1];
            }
            int[] votes = new int[n+1];
            Arrays.fill(votes, 0);
            for (int i = 0; i < n; i++) {
                if (i > 0) binaryL(nums, pref, votes, i - 1);
                if (i < n - 1) binaryR(nums, pref, votes, i + 1);

            }
            for (int i = 1; i < n; i++) {
                votes[i] += votes[i-1];
            }
            for (int i = 0; i < n; i++) {
                System.out.print(votes[i]+" ");
            }
            System.out.println();
        }
    }

    private static void binaryL(int[] nums, int[] pref, int[] votes, int i) {

        int low = 0, high = i,ans = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low +(high - low)/2;
            if (pref[i] - pref[mid] == nums[i + 1]) {
                ans = mid;
                break;
            }else if(pref[i] - pref[mid] < nums[i + 1]){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        votes[ans]++;
        votes[i + 1]--;
    }

    private static void binaryR(int[] nums, int[] pref, int[] votes, int i) {

        int low = i, high = nums.length - 1,ans= Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low +(high - low)/2;
            if (pref[mid - 1] - pref[i - 1] == nums[i - 1]) {
                ans = mid;
                break;
            }else if (pref[mid - 1] - pref[i - 1] < nums[i - 1]){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        votes[ans +1]--;
        votes[i]++;
    }
}
