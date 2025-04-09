// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp !=null){
            size++;
            temp = temp.next;
        }
        temp = head;
        ListNode prev = null;
        int i = 0;
        if(i == size - n){
            return head.next;
        }
        while(i != size - n){
            i++;
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
}