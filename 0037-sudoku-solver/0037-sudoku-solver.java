class Solution {
    public void solveSudoku(char[][] board) {
        boolean ans = solve(board);
        return;
    }

    public static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isvalid(i,j,c,board)){
                            board[i][j]=c;

                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isvalid(int row, int col, char c, char[][] board){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==c) return false;

            if(board[row][i]==c) return false;

            int subGridRow = 3*(row/3) + i/3;
            int subGridCol = 3*(col/3) + i%3;

            if(board[subGridRow][subGridCol]==c) return false;

        }
        return true;
    }
}