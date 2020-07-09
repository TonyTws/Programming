package TwoPointers.Assignment.Assignment2TwoPointersD26;

import java.util.Arrays;

/**
 * Question Link
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/361039470/ *
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    private static int lengthOfLongestSubstring(String str) {
        if(str.length() == 0) return 0;
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        int s =0, e =0, ans = 1,j=1;
        pos[str.charAt(0)] = 0;

        while(j < str.length()){
            if(pos[str.charAt(j)] == -1){
                pos[str.charAt(j)] = j;
                e++;
            }else{
                int k = pos[str.charAt(j)];
                for (int i = s; i <=k ; i++) {
                    pos[str.charAt(i)] = -1;
                    s++;
                }
                e++;
                pos[str.charAt(e)] = e;
            }
            ans = Math.max(ans,(e -s +1));
            j++;
        }
        return ans;
    }
}
