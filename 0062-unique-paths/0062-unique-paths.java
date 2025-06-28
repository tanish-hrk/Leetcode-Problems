class Solution {
    public static int solve(int i, int j, int[][] memo){
        if(i==0 && j==0) return 1;

        if(i<0 || j<0) return 0;

        if(memo[i][j]!=-1) return memo[i][j];

        int up = solve(i-1,j,memo);
        int left = solve(i,j-1,memo);

        memo[i][j] = up+left;
        return memo[i][j];
    }

    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }

        return solve(m-1,n-1,memo);
    }
}