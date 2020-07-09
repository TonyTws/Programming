package Extra.TCS;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestCharacter {
    public static void main(String[] args ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] s = str.toCharArray();
        Arrays.sort(s);
        System.out.println(s[0]);
    }
}
