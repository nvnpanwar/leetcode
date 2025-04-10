// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    int prev;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        ans = Integer.MAX_VALUE;
        minDif(root) ;
        return ans;
    }
    public void minDif(TreeNode root){
        if(root == null){
            return;
        }
        minDif(root.left);
        if(prev != -1){
            ans = Math.min(Math.abs(prev - root.val),ans);
        }
        prev = root.val;
        minDif(root.right);
    }

}