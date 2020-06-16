package Assignment4SortingD20;

import java.util.Arrays;
import java.util.Scanner;

public class EquationSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t-- > 0)) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i <n ; i++) {
                int num = sc.nextInt();
                nums[i] = (int)(A*Math.pow(num,2) + B*num + C);
            }
            int[] ans = sorted(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static int[] sorted(int[] A) {
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                k = i;
                break;
            }
        }
        return merge(k-1, 0, k, A.length - 1, A);

    }

    private static int[] merge(int i1, int j1, int i2, int j2, int[] nums) {
        int[] temp = new int[nums.length];
//        System.out.println(i1+" "+ j1+" "+i2+" "+j2);
        int index = 0;
        while (i1 >= j1 && i2 <= j2) {
//            System.out.println(i1+" "+i2);
            if(nums[i1] <= nums[i2]){
                temp[index++] = nums[i1--];
            }else{
                temp[index++] = nums[i2++];
            }
        }
        while (i1>=j1) {
            temp[index++] = nums[i1--];
        }
        while (i2<=j2) {
            temp[index++] = nums[i2++];
        }
        return temp;

    }
}
