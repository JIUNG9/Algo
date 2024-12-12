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
    public ListNode oddEvenList(ListNode head) {
   
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode oddPointer = head;
        ListNode evenPointer = head.next;
        ListNode evenCache = head.next;

        while(evenPointer != null && evenPointer.next!= null){
            oddPointer.next = oddPointer.next.next;
            oddPointer = oddPointer.next;
            evenPointer.next = evenPointer.next.next;
            evenPointer = evenPointer.next;
        }
            
 

        oddPointer.next = evenCache;

        return head;
    }
}