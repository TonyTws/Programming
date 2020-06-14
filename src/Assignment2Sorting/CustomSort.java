package Assignment2Sorting;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Question Link
 * https://leetcode.com/problems/custom-sort-string/
 *
 * Answer Link
 * https://leetcode.com/submissions/detail/353049156/
 *
 */

public class CustomSort {
    public static void main(String[] args) {
        CustomSort c = new CustomSort();
        System.out.println(c.customSortString("bca","abcd"));
    }
    public String customSortString(String S, String T) {
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'] = i;
        }

        Character[] t = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            t[i] = T.charAt(i);
        }

        Arrays.sort(t, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                System.out.println(o1+" "+o2);
                return index[o1 - 'a'] - index[o2 - 'a'];
            }
        });
        StringBuilder sb = new StringBuilder(t.length);
        for (Character c : t)
            sb.append(c.charValue());

        return sb.toString();
    }
}
