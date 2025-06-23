class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        ans[0] = first;
        int idx=0;
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i - 1] ^ encoded[idx];
            idx++;
        }
        return ans;
    }
}