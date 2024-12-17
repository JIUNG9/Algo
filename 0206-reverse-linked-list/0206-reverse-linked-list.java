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
    public ListNode answer;
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        reverseHelper(head,head.next);
        return answer;
    }
    public void reverseHelper(ListNode prev, ListNode curr){
        if(curr==null) {
            answer = prev;
            return;
        }
        reverseHelper(prev.next,curr.next);
        prev.next = null;
        curr.next = prev;
    }
}