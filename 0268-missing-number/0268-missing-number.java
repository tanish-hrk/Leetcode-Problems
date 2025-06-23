class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans ^= nums[i]; 
        }
        int ans2=0;
        for(int i = 1; i<=n ; i++) {
            ans2 ^= i;
        }
        return ans^ans2;
    }
}
