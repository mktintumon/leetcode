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
    public ListNode removeElements(ListNode head, int val) {
    ListNode temp = new ListNode(-1);
    temp.next = head;
    ListNode curr = temp;
    
    while(curr!=null){
        if(curr.next!=null && curr.next.val == val) curr.next = curr.next.next;
        else curr = curr.next;
    }
    
    return temp.next;
    }
}

/*
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)  return head;
        
        ListNode temp = head;
        
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        
        temp = head;
        if(temp.val == val){
            head = head.next;
        }
        
        return head;        
    }
}
*/