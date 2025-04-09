// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode greater = new ListNode();
        ListNode tempLess = less;
        ListNode tempGreater = greater;
        while(head != null){
            ListNode temp = new ListNode(head.val);
            if(head.val < x){
                less.next = temp;
                less = less.next;
            }
            else{
                greater.next = temp;
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = tempGreater.next;
        return tempLess.next;

    }
}