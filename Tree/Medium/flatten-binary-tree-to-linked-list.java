// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            TreeNode temp =root.right;
            root.right = root.left;
            TreeNode left = root.left;
            while(left.right != null){
                left = left.right;
            }
            left.right = temp;
            root.left = null;
        }
        flatten(root.left);
        flatten(root.right);
    }
}