// https://leetcode.com/problems/merge-two-sorted-lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while(list1 != null || list2 != null){
            int val = Integer.MAX_VALUE;
            if(list1 == null){
                val = list2.val;
                list2 = list2.next;
            }
            else if(list2 == null){
                val = list1.val;
                list1 = list1.next;
            }
            else{
                if(list1.val <= list2.val){
                    val = list1.val;
                    list1 = list1.next;
                }
                else{
                    val = list2.val;
                    list2 = list2.next;
                }
            }
            ListNode temp = new ListNode(val);
            pre.next = temp;
            pre = pre.next;
        }
        return ans.next;
    }
}