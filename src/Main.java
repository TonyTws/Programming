import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            List<String> words = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                words.add(sc.next());
            }
            int n = sc.nextInt(), m = sc.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.next().charAt(0);
                }
            }

            for (String word : words) {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (solve(grid, word, i, j, 0)) {
                            flag = true;
                        }
                    }

                }
                if (flag) {
                    System.out.println(word);
                }
            }
        }
    }

    public static boolean solve(char[][] grid, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (!isSafe(grid, i, j) || word.charAt(index) != grid[i][j]) return false;

        char ch = grid[i][j];
        grid[i][j] = '*';
        if (solve(grid, word, i + 1, j, index + 1) || solve(grid, word, i - 1, j, index + 1) ||
                solve(grid, word, i, j + 1, index + 1) || solve(grid, word, i, j - 1, index + 1) ||
                solve(grid, word, i - 1, j - 1, index + 1) || solve(grid, word, i - 1, j + 1, index + 1) ||
                solve(grid, word, i + 1, j - 1, index + 1) || solve(grid, word, i + 1, j + 1, index + 1)) {
            return true;
        }
        grid[i][j] = ch;
        return false;
    }

    public static boolean isSafe(char[][] grid, int i, int j) {
        return (0 <= i && i < grid.length) && (0 <= j && j < grid[0].length);
    }

    public static void printArray(char[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }


}
