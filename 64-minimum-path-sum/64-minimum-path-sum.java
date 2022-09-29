class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                if (r == n - 1 && c == m - 1) {
                    dp[r][c] = grid[r][c];
                } else if (r == n - 1) {
                    dp[r][c] = dp[r][c + 1] + grid[r][c];
                } else if (c == m - 1) {
                    dp[r][c] = dp[r + 1][c] + grid[r][c];
                } else {
                    int min = Math.min(dp[r + 1][c], dp[r][c + 1]);
                    dp[r][c] = min + grid[r][c];
                }
            }
        }

        return dp[0][0];
    }
}