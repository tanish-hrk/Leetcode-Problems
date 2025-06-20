class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n=nums.length;
        boolean[] vis = new boolean[n];
        solve(nums,temp,vis,ans);

        return ans;
    }
    static void solve(int[] nums, List<Integer> temp, boolean[] vis, List<List<Integer>> ans){
        if(temp.size()==nums.length){
            ans.add(new ArrayList(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]==false){
                vis[i]=true;
                temp.add(nums[i]);

                //explore
                solve(nums,temp,vis,ans);

                //undo
                temp.remove(temp.size()-1);
                vis[i]=false;

            }
        }
    }
}