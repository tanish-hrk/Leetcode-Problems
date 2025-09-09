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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode rootleft, TreeNode rootright) {
        if (rootleft == null && rootright == null)
            return true;
        else if (rootleft == null || rootright == null)
            return false;
        if (rootleft.val != rootright.val)
            return false;
        if (!isSymmetric(rootleft.left, rootright.right))
            return false;
        if (!isSymmetric(rootleft.right, rootright.left))
            return false;
        return true;
    }
}
