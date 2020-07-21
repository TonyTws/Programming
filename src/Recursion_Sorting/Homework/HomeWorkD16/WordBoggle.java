package Recursion_Sorting.Homework.HomeWorkD16;


import java.util.*;
import java.lang.*;

/**
 * Question Link
 * https://practice.geeksforgeeks.org/problems/word-boggle/0
 * Answer Link
 * https://practice.geeksforgeeks.org/viewSol.php?subId=b5bcafa80cae69005b30c45d65e9c66d&pid=1653&user=shankarchakraborty1
 */

class WordBoggle {

    static boolean flag = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int x = sc.nextInt();
            String words[] = new String[x];

            for (int j = 0; j < x; j++) {
                words[j] = sc.next();
            }

            int n = sc.nextInt();
            int m = sc.nextInt();
            char board[][] = new char[n][m];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    board[j][k] = sc.next().charAt(0);
                }
            }
            Set<String> l = new HashSet<>();

            for (int k = 0; k < x; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (board[i][j] == words[k].charAt(0)) {
                            solve(i, j, board, words[k], 1);
                            if (flag) {
                                l.add(words[k]);
                                break;
                            }

                        }
                    }
                    if (flag) {
                        flag = false;
                        break;
                    }
                }
            }
            List<String> ans = new ArrayList<>(l);

            if(ans.size() ==0){
                System.out.println("-1");
            }else {
                Collections.sort(ans);
                for (int i = 0; i < l.size(); i++) {

                    System.out.print(ans.get(i) + " ");
                }

                System.out.println();
            }
        }

    }

    public static boolean isSafe(int i, int j, char[][] grid) {

        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && (grid[i][j] != '*'));

    }

    public static void solve(int i, int j, char[][] grid, String word, int x) {
        if (flag)
            return;
        if (x == word.length()) {
            flag = true;
            return;
        }

        char ch = grid[i][j];
        grid[i][j] = '*';

        if (isSafe(i + 1, j, grid) && grid[i + 1][j] == word.charAt(x)) {

            solve(i + 1, j, grid, word, x + 1);

        }

        if (isSafe(i + 1, j - 1, grid) && grid[i + 1][j - 1] == word.charAt(x)) {

            solve(i + 1, j - 1, grid, word, x + 1);

        }
        if (isSafe(i + 1, j + 1, grid) && grid[i + 1][j + 1] == word.charAt(x)) {

            solve(i + 1, j + 1, grid, word, x + 1);

        }
        if (isSafe(i - 1, j - 1, grid) && grid[i - 1][j - 1] == word.charAt(x)) {

            solve(i - 1, j - 1, grid, word, x + 1);

        }
        if (isSafe(i - 1, j + 1, grid) && grid[i - 1][j + 1] == word.charAt(x)) {

            solve(i - 1, j + 1, grid, word, x + 1);

        }
        if (isSafe(i, j - 1, grid) && grid[i][j - 1] == word.charAt(x)) {

            solve(i, j - 1, grid, word, x + 1);

        }

        if (isSafe(i, j + 1, grid) && grid[i][j + 1] == word.charAt(x)) {

            solve(i, j + 1, grid, word, x + 1);

        }
        if (isSafe(i - 1, j, grid) && grid[i - 1][j] == word.charAt(x)) {

            solve(i - 1, j, grid, word, x + 1);

        }
        grid[i][j] = ch;

    }

}