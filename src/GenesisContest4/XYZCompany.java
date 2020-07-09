package GenesisContest4;

import java.util.Arrays;
import java.util.Scanner;

public class XYZCompany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long q = sc.nextLong();
        long[] rating = new long[(int) n];
        for (int i = 0; i < n; i++) {
           rating[i] = sc.nextLong();
        }
        for (int i = 0; i < q; i++) {
            long Q = sc.nextLong();
            System.out.println(solve(rating,Q));
        }
    }

    private static long solve(long[] rating, long q) {
        Arrays.sort(rating);
//        System.out.println(greater(rating,q));
//        System.out.println(smaller(rating,q));
        long i = greater(rating,q);
        long j = smaller(rating,q);
        if( i == -1 || j == -1) return -1;
        else return rating[(int) i] - rating[(int) j];

    }
    private static long greater(long[] arr, long target)
    {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    private static long smaller(long[] arr, long target)
    {
        int start = 0, end = arr.length-1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
