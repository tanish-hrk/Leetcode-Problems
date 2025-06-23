class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] v = new boolean[n+1];
        for(int i = 0; i < nums.length; i++) {
            v[nums[i]] = true;
        }
        for(int i = 0; i < v.length; i++) {
            if(v[i] == false) return i;
        }
        return 0;
    }
}
