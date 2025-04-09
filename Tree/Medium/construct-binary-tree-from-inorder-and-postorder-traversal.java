// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=inorder.length -1;
        return buildTreeRec(null, inorder, postorder, 0, inorder.length);
    }
    public TreeNode buildTreeRec(TreeNode root, int[] inorder, int[] postorder, int start, int end){
        if(i<0){
            return null;
        }
        if(end <= start){
            return null;
        }
        root = new TreeNode(postorder[i--]);
        if(end - start == 1){
            return root;
        }
        int j = start;
        while(j<end && inorder[j] != root.val){
            j++;
        }
        TreeNode right = buildTreeRec(root, inorder, postorder, j+1, end);
        TreeNode left = buildTreeRec(root, inorder, postorder, start, j);
        root.left = left;
        root.right = right;
        return root;
    }
}