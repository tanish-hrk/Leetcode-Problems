class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyB = numBottles;

        while(emptyB>=numExchange){
            int newB = emptyB / numExchange;
            emptyB = newB + emptyB % numExchange;
            res += newB;
        }
        return res;
    }
}