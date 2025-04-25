// https://leetcode.com/problems/univalued-binary-tree/

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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return findIsUnivalTree(root);
    }
    public boolean findIsUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left== null && root.right == null){
            return true;
        }
        else if((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val) ){
            return false;
        }
        boolean left = findIsUnivalTree(root.left);
        boolean right = findIsUnivalTree(root.right);
        return left && right;
    }

}