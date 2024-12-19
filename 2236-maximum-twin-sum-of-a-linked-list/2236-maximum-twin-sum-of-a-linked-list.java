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
    private int answer =0;
    private int length = 0;
    private int counter = 0;
    private ListNode copy;
    public int pairSum(ListNode head) {
        copy = head;
        dfsHelper(head, 0);
        return answer;
    }
    public void dfsHelper(ListNode pointer, int depth){
        if(pointer == null){length = depth; return; } 
        dfsHelper(pointer.next,depth+1);
        if(counter++ < length/2){
            answer = Math.max(answer, copy.val + pointer.val);
            copy = copy.next;
        }
    }
}