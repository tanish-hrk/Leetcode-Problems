class Solution {
    int m, n;
    public int findMaxFish(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int max=0;

        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    max = Math.max(max,dfs(grid,i,j,vis));
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j, boolean[][] vis){
        vis[i][j]=true;
        int sum = grid[i][j];
        
       if(valid(i+1,j) && !vis[i+1][j] && grid[i+1][j]>0){       //dir (up) =i+1
        sum+=dfs(grid,i+1,j,vis);
       }
       if(valid(i-1,j) && !vis[i-1][j] && grid[i-1][j]>0){       //dir (bottom) =i-1
        sum+=dfs(grid,i-1,j,vis);
       }
       if(valid(i,j+1) && !vis[i][j+1] && grid[i][j+1]>0){       //dir (right) =j+1
        sum+=dfs(grid,i,j+1,vis);
       }
       if(valid(i,j-1) && !vis[i][j-1] && grid[i][j-1]>0){       //dir (left) =j-1
        sum+=dfs(grid,i,j-1,vis);
       }
    return sum;
    }

    boolean valid(int i, int j){
        if(i>=m || j>=n || i<0 || j<0 ){
            return false;
        }
        return true;
    }

}