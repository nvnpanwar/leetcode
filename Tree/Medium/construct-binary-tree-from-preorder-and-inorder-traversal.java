// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    int i=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        // int i = 0;
        // while(i < inorder.length && inorder[i] != preorder[0].val){
        //     i++;
        // }
        return build(root, 0, preorder.length, preorder, inorder);
    }
    public TreeNode build(TreeNode root, int start, int end, int[] preorder, int[] inorder){
        if(i>=preorder.length){
            return null;
        }
        else if(end <= start){
            return null;
        }
        root = new TreeNode(preorder[i++]);
        if(end - start == 1){
            return root;
        }
        int j = start;
        while(j< end && inorder[j] != root.val){
            j++;
        }
        TreeNode left = build(root, start, j, preorder, inorder);
        TreeNode right = build(root,  j+1, end, preorder, inorder);
        root.left = left;
        root.right = right;
        return root;
    }
}