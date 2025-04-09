// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            Queue<TreeNode> queue2 = new LinkedList<>();
            List<Integer> list2 = new ArrayList<>();
            count++;
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                list2.add(node.val);
                if(node.left != null){
                    queue2.add(node.left);
                }
                if(node.right != null){
                    queue2.add(node.right);
                }
            }
            if(count % 2 == 0){
                Collections.reverse(list2);
            }
            list.add(list2);
            queue = queue2;
        }
        return list;
    }
}