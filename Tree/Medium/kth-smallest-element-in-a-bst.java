// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    int val;
    int kth;
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        val = 0;
        findVal(root);
        return val;
    }
    public void findVal(TreeNode root){
        if(root ==null){
            return;
        }
        findVal(root.left);
        kth--;
        if(kth==0){
            val = root.val;
        }
        findVal(root.right);

    }
}