// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode temp = head;
        if(head == null) return head;
        int val = temp.val;
        while(temp != null){
            val = temp.val;
            temp = temp.next;
            if(temp != null && val != temp.val){
                break;
            }
            while(temp != null && val == temp.val){
                temp = temp.next;
                head = temp;
            }
            
        }
        temp = head;
        while(temp!=null){
            ListNode pre = temp;
            temp = temp.next;
            int count = 0;
            if(temp != null){
                val = temp.val;
            }
            else{
                break;
            }
            while(temp != null && val == temp.val){
                count++;
                temp = temp.next;
            }
            if(count == 1){
                temp = pre.next;
            }
            else{
                pre.next = temp;
                temp = pre;
            }
        }
        return head;
    }
}