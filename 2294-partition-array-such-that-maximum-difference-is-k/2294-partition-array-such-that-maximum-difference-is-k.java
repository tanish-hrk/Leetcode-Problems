class Solution {
        public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, min = nums[0], max = nums[0];
        for (int a: nums) {
            min = Math.min(min, a);
            max = Math.max(max, a);
            if (max - min > k) {
                res++;
                min = max = a;
            }
        }
        return res;
    }
}