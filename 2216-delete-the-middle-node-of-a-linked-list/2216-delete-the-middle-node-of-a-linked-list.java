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
    public ListNode deleteMiddle(ListNode head) {
        // 1. 전체 노드의 숫자를 구한다.
        // 2. 처음부터 시작하여 (처음 idx는 0이다.), count가 중간에 다 달았을 때, 그때만 ListNode next가 그 이후의 next를 가르키게 한다.
        ListNode cache1 = head;
        ListNode cache2 = head;
        int totalCount = 1;
        if(head.next == null) return null;

        while(cache1.next!=null){
            totalCount++;
            cache1 = cache1.next;
        }

        int targetCount = totalCount / 2;
        int idx = 0;

        while(idx != targetCount - 1){
                cache2 = cache2.next;
                idx++;
        }
        cache2.next = cache2.next.next;
        return head;
    }
}