class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        // Create an array of lists where index = frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }

        // Gather top K frequent elements from the highest frequencies
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // Convert list to array
        return result.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
