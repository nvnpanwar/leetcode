// https://leetcode.com/problems/count-complete-tree-nodes

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
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        if(root == null){
            return count;
        }
        countNodesRec(root);
        return count;
    }
    void countNodesRec(TreeNode root){
        if(root == null){
            return;
        }
        count++;
        countNodesRec(root.left);
        countNodesRec(root.right);

    }
}