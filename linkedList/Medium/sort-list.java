// https://leetcode.com/problems/sort-list

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
    public ListNode sortList(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            ListNode temp2 = temp.next;
            while(temp2 !=null){
                if(temp.val > temp2.val ){
                    int val = temp2.val;
                    temp2.val = temp.val;
                    temp.val = val;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return head;

    }
}