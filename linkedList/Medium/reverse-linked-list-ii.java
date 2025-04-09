// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = head;
        ListNode lh = head;
        ListNode prev = null;
        int i = 1;
        while(lh != null && i < left ){
            i++;
            prev = lh;
            lh = lh.next;
        }
        
        ListNode pre = null;
        while(lh!=null && i < right){
            ListNode temp = lh.next;
            lh.next = pre;
            pre = lh;
            lh = temp;
            i++;
        }
        if(lh == null){
            if(prev != null){
                prev.next = pre;
            }
            return head;   
        }
        ListNode temp = lh.next;
        lh.next = pre;
        if(left == 1){
            head = lh;
        }
        if(prev != null){
            prev.next = lh;
        }
        while(lh != null){
            prev = lh;
            lh = lh.next;
        }
        if(prev != null){
            prev.next = temp;
        }
        return head;
    }
}