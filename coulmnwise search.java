import java.util.Scanner;

public class MaxPathSumColumnWise {

    public static long getMax(long[][] grid, int r, int c) {

        long[][] dp = new long[r][c];

        // First column remains the same
        for (int row = 0; row < r; row++) {
            dp[row][0] = grid[row][0];
        }

        // Fill DP table column-wise
        for (int col = 1; col < c; col++) {

            for (int row = 0; row < r; row++) {

                long fmax = dp[row][col - 1]; // same row

                if (row > 0) {
                    fmax = Math.max(fmax, dp[row - 1][col - 1]); // upper diagonal
                }

                if (row < r - 1) {
                    fmax = Math.max(fmax, dp[row + 1][col - 1]); // lower diagonal
                }

                dp[row][col] = grid[row][col] + fmax;
            }
        }

        // Find maximum in last column
        long ans = dp[0][c - 1];

        for (int row = 1; row < r; row++) {
            if (dp[row][c - 1] > ans) {
                ans = dp[row][c - 1];
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
    }
}
