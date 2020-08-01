package Hashing_Stacks_Queues_Linkedlist.Assignment.Assignment2HashingD31;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Question Link
 * https://codeforces.com/contest/713/problem/A
 * <p>
 * Answer Link
 * https://codeforces.com/contest/713/submission/88062181
 */

public class SonyaAndQueries {
    public static void main(String[] args) {
        HashMap<Long, Long> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char query = sc.next().charAt(0);
            long num = sc.nextLong();
            if (query == '+') {
                long no = convertToBinary(num);
                if (map.containsKey(no)) {
                    map.put(no, map.get(no) + 1);
                } else {
                    map.put(no, (long) 1);
                }
            } else if (query == '-') {
                long no = convertToBinary(num);
                if (map.containsKey(no)) {
                    map.put(no, map.get(no) - 1);
                }
            } else {
                long no = convertToNumber(String.valueOf(num));
                if (map.get(no) == null) {
                    System.out.println(0);
                } else {
                    System.out.println(map.get(no));
                }
            }

        }
        System.exit(0);
    }

    private static long convertToNumber(String num) {
        return Integer.parseInt(num, 2);
    }

    private static long convertToBinary(long num) {
        long ans = 0;
        int i = 0;
        while (num > 0) {
            long no = num % 10;
            if (no % 2 != 0) {
                ans += Math.pow(2, i);
            }
            i++;
            num /= 10;
        }
        return ans;
    }
}
