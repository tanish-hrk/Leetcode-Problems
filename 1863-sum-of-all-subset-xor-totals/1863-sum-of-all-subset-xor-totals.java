class Solution {
    static int ans;

    public int subsetXORSum(int[] nums) {
        ans = 0;
        solve(0, nums, 0);
        return ans;
    }

    static void solve(int i, int[] nums, int curr) {
        if (i >= nums.length) {
            ans += curr;
            return;
        }

        // Include nums[i] in XOR
        solve(i + 1, nums, curr ^ nums[i]);

        // Exclude nums[i]
        solve(i + 1, nums, curr);
    }
}
