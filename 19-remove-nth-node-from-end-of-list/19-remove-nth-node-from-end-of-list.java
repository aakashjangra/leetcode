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
        ListNode slow = new ListNode(123);
        ListNode fast = new ListNode(123);
        slow.next = head;
        fast.next = head;
        
        head = slow;
        
        int count = 0;
        
        while(fast != null && fast.next != null){
            if(count < n){
                fast = fast.next;
                count++;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        slow.next = slow.next.next;
        
        return head.next;
    }
}