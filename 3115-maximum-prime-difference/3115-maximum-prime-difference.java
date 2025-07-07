class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // the index of the first prime
        while (start < end) {
            if (isPrime(nums[start])) {
                break;
            }
            start++;
        }

        // the index of the last prime
        while (end >= start) {
            if (isPrime(nums[end])) {
                break;
            }
            end--;
        }

        return end - start;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
