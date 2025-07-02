/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(0,root,ans);
        return ans;
    }
    
    private void DFS(int level ,TreeNode root, List<Integer> res){
        if(root==null) return;
        if(res.size()==level) res.add(root.val);
        DFS(level+1, root.right, res);
        DFS(level+1, root.left, res);
    }
}