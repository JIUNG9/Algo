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
    private int answer = 0;
    private ListNode headCache;
    public int pairSum(ListNode head) {
        headCache = head;
        pairSumHelper(head);
        return answer;
    }
    public void pairSumHelper(ListNode pointer){
        if(pointer == null) return;
        pairSumHelper(pointer.next);
        answer = Math.max(pointer.val+headCache.val,answer);
        headCache = headCache.next;
    }
}