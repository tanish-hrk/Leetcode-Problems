class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == x) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > x) {
                            ans[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        ans[i] = -1;
                    break;
                }
            }
        }
        return ans;
    }
}