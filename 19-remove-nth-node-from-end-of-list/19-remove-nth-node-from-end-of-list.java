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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        int size = 0;
        while(fast != null){
            fast = fast.next;
            size++;
        }
        
        if(size == n){
            return head.next;
        }
        
        for(int i = 0; i < size-n-1; i++){
            head = head.next;
        }
        
        head.next = head.next.next;
        
        return slow;
    }
}