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
    
    public ListNode rotateRight(ListNode head, int k) {
        ListNode copy = head;
        
        
        if(head == null || head.next == null || k == 0) return head;

        ListNode firstPointer = null;
        ListNode secondPointer = null;
        ListNode firstPointerHeader = null;
        ListNode secondPointerHeader = null;
        int totalNum = getCount(copy, k);
        k = k % totalNum;
        if(k == 0) return head;

        for(int i = 0; i < totalNum - k ; i++){
            if(i == 0) {firstPointer = new ListNode(head.val); firstPointerHeader = firstPointer; }  
            else {firstPointer.next = new ListNode(head.val); firstPointer = firstPointer.next; } 
            head = head.next;
        }

        for(int j = totalNum - k ; j < totalNum; j++){
            if(j == totalNum - k) {secondPointer = new ListNode(head.val); secondPointerHeader = secondPointer;}
            else {secondPointer.next = new ListNode(head.val); secondPointer = secondPointer.next;}
            head = head.next;
        }

            secondPointer.next = firstPointerHeader;

        return secondPointerHeader;
        
    }
    

    public int getCount(ListNode copy, int k){
        int count = 0;

        while(copy != null){
            copy = copy.next;
            count++;
        }
        return count;
    }
}

 
