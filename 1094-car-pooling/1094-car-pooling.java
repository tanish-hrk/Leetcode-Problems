class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pre= new int[1001];

        for(int[] currtrip:trips){
            int passenger = currtrip[0];
            int currstart = currtrip[1];
            int currend = currtrip[2];

            pre[currstart]+=passenger;
            pre[currend]-=passenger;
        }

        for(int i=1;i<1001;i++){
            pre[i]+=pre[i-1];
        }

        for(int it:pre){
            if(it>capacity) return false;
        }

        return true;
    }
}