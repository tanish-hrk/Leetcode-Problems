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
    int sum;
    public int maxPathSum(TreeNode root) {
        sum=Integer.MIN_VALUE;
        path(root);
        return sum;
    }

    private int path(TreeNode root){
        if(root==null) return 0;

        int l = Math.max(0,path(root.left));
        int r = Math.max(0,path(root.right));
    
        sum=Math.max(sum, l+r+root.val);
        return Math.max(l,r)+ root.val;
    }
}