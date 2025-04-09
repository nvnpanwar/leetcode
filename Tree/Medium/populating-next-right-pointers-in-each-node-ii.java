// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            Queue<Node> queue2 = new LinkedList<>();
            while(!queue.isEmpty()){
                Node node = queue.peek();
                queue.remove();
                if(queue.isEmpty()){
                    node.next = null;
                }
                else{
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue2.add(node.left);
                }
                if(node.right != null){
                    queue2.add(node.right);
                }
            }
            queue = queue2;
        }
        return root;
    }
}