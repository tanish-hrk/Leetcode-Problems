class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int first = -1;
        int last = -1;

        // Find the first prime's index
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                first = i;
                break;
            }
        }

        // Find the last prime's index
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                last = i;
                break;
            }
        }

        // Return the difference if primes found
        return (first != -1 && last != -1) ? (last - first) : 0;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
