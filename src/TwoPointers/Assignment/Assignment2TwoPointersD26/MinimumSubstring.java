package TwoPointers.Assignment.Assignment2TwoPointersD26;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/364255102/
 */
public class MinimumSubstring {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(solve(S, T));
    }

    public static String solve(String s, String t) {
        String ans = "";
        if (s.length() == 0 || t.length() == 0) return ans;
        if (s.length() < t.length()) return ans;
        int[] freqT = new int[256];
        Arrays.fill(freqT, 0);
        int[] freqS = new int[256];
        Arrays.fill(freqS, 0);

        int count = 0;

        for (int i = 0; i < t.length(); i++) {
            if (freqT[t.charAt(i)] == 0) count++;
            freqT[t.charAt(i)]++;
        }
        //selecting initial window
        int start = 0, end = 0, fCount = 0, i;
        for (i = 0; i < s.length(); i++, end++) {
            freqS[s.charAt(i)]++;
            if (freqS[s.charAt(i)] == freqT[s.charAt(i)]) fCount++;
            if (count == fCount) break;
        }

        int ansStart, ansEnd, min = Integer.MAX_VALUE;
        while (end < s.length()) {
            int k = start;
            while (true) {
                if (freqT[s.charAt(k)] == 0) {
                    freqS[s.charAt(k)]--;
                    k++;
                } else if (freqS[s.charAt(k)] == freqT[s.charAt(k)]) {
                    break;
                } else {
                    freqS[s.charAt(k)]--;
                    k++;
                }
            }
            start = k;
            if (end - start + 1 < min) {
                min = end - start + 1;
                ansStart = start;
                ansEnd = end;
                ans = s.substring(ansStart, ansEnd + 1);
            }
            end++;
            if (end < s.length()) {
                freqS[s.charAt(end)]++;
            }
        }
        return ans;
    }
}
