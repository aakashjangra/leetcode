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
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        
        ListNode tail = head;
        int length = 1;
        
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        
        if(k % length == 0){
            return head;
        }
        
        ListNode prev = head;
        
        k = k % length;
        for(int i = 1; i<=length-k-1; i++){
            prev = prev.next;
        }
        
        
        ListNode ans = prev.next;
        prev.next = null;
        tail.next = head;
        
        return ans;
    }
}