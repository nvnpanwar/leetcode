// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        if(root == null){
            return 0;
        }
        sumNumbersRec(root, "");
        return ans;
    }
    public void sumNumbersRec(TreeNode root, String s){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            String str = s + ""+root.val;
            ans = ans + Integer.parseInt(str);
            return;
        }
        sumNumbersRec(root.left, s + ""+root.val);
        sumNumbersRec(root.right, s + ""+root.val);
    }
}