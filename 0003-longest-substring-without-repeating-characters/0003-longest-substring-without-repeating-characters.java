class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            if (!charMap.containsKey(s.charAt(i)) || charMap.get(s.charAt(i)) < left) {
                charMap.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - left + 1);
            } else {
                left = charMap.get(s.charAt(i)) + 1;
                charMap.put(s.charAt(i), i);
            }
        }
        
        return maxLength;
    }
}