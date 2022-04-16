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
    
    ListNode left ;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);        
    }
    
    public boolean helper(ListNode right){
        if(right == null){
            return true;
        }
        
        boolean recAns = helper(right.next);
        if(recAns == false){
            return false;
        }
        
        if(left.val != right.val){
            return false;
        }
        else{
            left = left.next;
            return true;
        }
    }
}