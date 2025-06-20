class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ls = new HashSet();
        solve(ls, new ArrayList(), nums, 0);
        return new ArrayList<>(ls);
    }

    private void solve(Set<List<Integer>> ls, List<Integer> tempList, int[] nums, int start) {
        ls.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            solve(ls, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}