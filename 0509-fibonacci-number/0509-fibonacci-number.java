class Solution {
    public int fib(int n) {
        return matrixExponentiation(n);
    }

    public static int matrixExponentiation(int n){
        if(n==0 || n==1) return n;

        int[][] T = {{1,1},{1,0}};
        int[][] F = {{1,0},{0,0}};

        int[][] power = pow(T,n-1);
        int[][] res = multiply(power,F);

        return res[0][0];
    }

    public static int[][] pow(int[][] M, int expo){
        //binary expo se
        if(expo==0){
            int[][] IdentityM = {{1,0},{0,1}};
            return IdentityM;
        }

        int[][] half = pow(M,expo/2);
        int[][] res = multiply(half,half);
        if(expo%2==1){
            res = multiply(M,res);
        }
        return res;
    }

    public static int[][] multiply(int[][] a, int[][] b){
        int[][] ans = new int[2][2];
        ans[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
        ans[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
        ans[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
        ans[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];

        return ans;
    }
}