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
    private int count = 0;
    private int size = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        size++;
        removeNthFromEnd(head.next, n);
        count++;
        //n+1을 넣은 이유는 이전에 스택에 쌓인 리스트의 다음이 그 다음을 가르킬 수 있게하기 위함, 하지만 그렇게 된다면, n까지밖에 조회를 못 하기에, head를 삭제할 수 없음
        if(n + 1 == count) head.next = head.next.next;

        return size == n ? head.next : head;
    }

}