// https://leetcode.com/problems/merge-k-sorted-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode ans = lists[0];
        int i=1;
        while(i< lists.length){
            boolean flag = false;
            ListNode temp = ans;
            ListNode node = lists[i];
            ListNode prev = null;
            while(node != null && temp != null){
                if(node.val >= temp.val){
                    prev = temp;
                    temp = temp.next;
                }
                else{
                    if(prev == null){
                        ListNode newNode = new ListNode(node.val);
                        newNode.next = temp;
                        ans = newNode;
                        prev = newNode;
                    }
                    else{
                        ListNode swapNode = temp;
                        prev.next = new ListNode(node.val);
                        prev.next.next = temp;
                        prev = prev.next;
                    }
                    node = node.next;
                }
            }
            if(node != null){
                if(prev != null){
                    prev.next = node;
                }
                else{
                    ans = node;
                }
            }
            i++;
        }
        return ans;
    }
}