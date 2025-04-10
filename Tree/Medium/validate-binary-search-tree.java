// https://leetcode.com/problems/validate-binary-search-tree

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
    long prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;
        isValid = true;
        isValidBSTRec(root);
        return isValid;
    }
    public void isValidBSTRec(TreeNode root){
        if(root == null){
            return;
        }
        isValidBSTRec(root.left);
        if(prev >= (long)root.val){
            isValid = false;
        }
        prev = root.val;
        isValidBSTRec(root.right);
    }
}