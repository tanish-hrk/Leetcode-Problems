class Solution {
    static int m,n;
    public int longestCommonSubsequence(String s1, String s2) {
        m=s1.length();
        n=s2.length();

        int[][] memo = new int[1001][1001];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        } 

        return solve(s1,s2,0,0,memo); 
    }

    static int solve(String s1,String s2,int i, int j,int[][] memo){
        if((i>=m) || (j>=n)) return 0;

        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j] = 1 + solve(s1,s2,i+1,j+1,memo);
            return memo[i][j];
        }
        else{
            memo[i][j]=Math.max(solve(s1,s2,i+1,j,memo), solve(s1,s2,i,j+1,memo));
            return memo[i][j];
        }
    }
}