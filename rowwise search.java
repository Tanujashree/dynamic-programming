import java.util.Scanner;

public class MaxPathSum {

    public static long getMax(long[][] grid, int r, int c) {

        long[][] dp = new long[r][c];

        // First row remains the same
        for (int col = 0; col < c; col++) {
            dp[0][col] = grid[0][col];
        }

        // Fill DP table
        for (int row = 1; row < r; row++) {

            for (int col = 0; col < c; col++) {

                long fmax = dp[row - 1][col]; // same column

                if (col > 0) {
                    fmax = Math.max(fmax, dp[row - 1][col - 1]); // left diagonal
                }

                if (col < c - 1) {
                    fmax = Math.max(fmax, dp[row - 1][col + 1]); // right diagonal
                }

                dp[row][col] = grid[row][col] + fmax;
            }
        }

        // Find maximum in last row
        long ans = dp[r - 1][0];

        for (int col = 1; col < c; col++) {
            if (dp[r - 1][col] > ans) {
                ans = dp[r - 1][col];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        long[][] grid = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextLong();
            }
        }

        System.out.println(getMax(grid, r, c));

        sc.close();
    }
}
