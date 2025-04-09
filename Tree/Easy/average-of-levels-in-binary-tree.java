// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> queue2 = new LinkedList<>();
            double count = 0;
            double sum = 0;
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                sum = sum + (double)node.val;
                count++;
                if(node.left != null){
                    queue2.add(node.left);
                }
                if(node.right != null){
                    queue2.add(node.right);
                }
            }
            list.add(sum/count);
            queue = queue2;
        }
        return list;
    }
}