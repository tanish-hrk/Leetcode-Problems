class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // obstacle: zero paths to this cell
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // sum of top and left paths
                }
            }
        }
        
        return dp[n - 1];
    }
}
