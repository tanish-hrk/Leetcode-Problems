class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;

        while(numBottles>=numExchange){
            numBottles = numBottles-numExchange;
            numExchange+=1;
            res+=1;
            numBottles+=1;
        }
        return res;
    }
}