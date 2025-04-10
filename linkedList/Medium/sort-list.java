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
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=middle(head);
        ListNode headB=mid.next;
        mid.next=null;
        ListNode a=sortList(head);
        ListNode b=sortList(headB);
        return Merge(a,b);
    }
    public ListNode Merge(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                dummy.next=list1;
                dummy=dummy.next;
                list1=list1.next;
            }
            else{
                dummy.next=list2;
                dummy=dummy.next;
                list2=list2.next;
            }
        }
        if(list1==null){
            dummy.next=list2;
        }
        if(list2==null){
            dummy.next=list1;
        }
        return temp.next;
    }
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}

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
// class Solution {
//     public ListNode sortList(ListNode head) {
//         int size = 0;
//         ListNode temp = head;
//         while(temp != null){
//             ListNode temp2 = temp.next;
//             while(temp2 !=null){
//                 if(temp.val > temp2.val ){
//                     int val = temp2.val;
//                     temp2.val = temp.val;
//                     temp.val = val;
//                 }
//                 temp2 = temp2.next;
//             }
//             temp = temp.next;
//         }
//         return head;

//     }
// }