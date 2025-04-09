// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorRec(root, p,q);
    }
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestorRec(root.left, p, q);
        TreeNode right = lowestCommonAncestorRec(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else return right;
    }
}