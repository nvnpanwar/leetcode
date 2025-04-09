// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 == null) {
                l2Val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                l1Val = l1.val;
                l1 = l1.next;
            } else {
                l1Val = l1.val;
                l2Val = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            int val = l1Val + l2Val + carry;
            carry = val / 10;
            ListNode temp = new ListNode(val % 10);
            pre.next = temp;
            pre = pre.next;
        }
        if(carry != 0){
            int val = carry;
            ListNode temp = new ListNode(val);
            pre.next = temp;
        }
        return ans.next;
    }
}