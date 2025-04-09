// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        k = k % size;
        if(k==0){
            return head;
        }
        int i=0;
        ListNode prev = null;
        ListNode listHead = head;
        temp = head;
        while(temp != null){
            i++;
            prev = temp;
            temp = temp.next;
            if(i == size - k){
                break;
            }
        }
        prev.next = null;
        head = temp;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        if(temp!=null){
            temp.next = listHead;
        }
        return head;
    }
}