package RecursionAndSorting.Assignment.Assignment5SortingD21;

import java.util.Scanner;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/inversion-of-array/0
 *
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=1944702e5489830c85ca67f41618594c&pid=558&user=shankarchakraborty1
 *
 */

public class InversionsCount {
    static int[] temp = new int[10000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(inversionCount(nums,0,nums.length-1));
        }
    }

    private static long inversionCount(int[] nums,int start,int end) {
        long count =0;
        if(start < end) {
            int mid = start + (end - start) / 2;
            count += inversionCount(nums, start, mid);
            count += inversionCount(nums, mid + 1, end);
            count += merge(nums, start, mid, end);
        }
        return count;
    }

    private static long merge(int[] nums, int start, int mid, int end) {
        long count =0;
        int s1 = start, e1 = mid, s2 = mid+1, e2 = end;
        int index = start;
        while (s1 <= e1 && s2<= e2){
            if(nums[s1] <= nums [s2]){
                temp[index++] = nums[s1++];
            }else{
                count += e1 - s1 +1;
                temp[index++] = nums[s2++];
            }
        }
        while(s1 <= e1){
            temp[index++] = nums[s1++];
        }
        while(s2<=e2){
            temp[index++] = nums[s2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        return count;
    }
}
