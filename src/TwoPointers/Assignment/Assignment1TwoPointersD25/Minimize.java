package TwoPointers.Assignment.Assignment1TwoPointersD25;

import java.util.Scanner;

/**
 * Question Link
 * https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/
 *
 * Answer Link
 * https://ideone.com/NhR08G
 */
public class Minimize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), p = sc.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        int[] C = new int[p];
        for (int i = 0; i < p; i++) {
            C[i] = sc.nextInt();
        }
        System.out.println(solve(A,B,C));

    }

    private static int solve(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;
        int m = A.length, n = B.length, p = C.length;
        int i =0, j=0, k =0;
        while(i<m && j<n && k <p){
            int num = Math.max(A[i],Math.max(B[j],C[k])) - Math.min(A[i],Math.min(B[j],C[k]));
            ans = Math.min(ans, num);

            // decide which pointer to move
            if(A[i]< B[j] && A[i] < C[k]){
                i++;
            }else if(B[j]< A[i] && B[j] < C[k]){
                j++;
            }else{
                k++;
            }
        }
        return ans;
    }
}
