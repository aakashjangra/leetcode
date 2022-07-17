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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode p = new ListNode(999);
        ListNode c = head;
        ListNode n = c.next;
        ListNode ans = n;
        
       
        
        while(c != null && n != null && n.next != null){
            c.next = n.next;
            n.next = c;
            p.next = n;
            p = c;
            c = p.next;
            n = c.next;
        }
        
        if(n == null){
            return ans;
        }
        
        c.next = n.next;
        n.next = c;
        p.next = n;
        
        return ans;
    }
}