class Solution {
    public int maximumPrimeDifference(int[] nums)
     {
        int i = 0, j = nums.length - 1;
        while (!isPrime(nums[i])) 
        {
            i++;
        }
        while (!isPrime(nums[j])) 
        {
            j--;
        }
        return j - i;
    }
    private boolean isPrime(int x) 
    {
        if (x < 2) return false;
        for (int v = 2; v * v <= x; v++)
        {
            if (x % v == 0) return false;
        }
        return true;
    }
}v