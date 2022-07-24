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
    public ListNode partition(ListNode head, int x) {
        ListNode sorted = new ListNode(0);
        
        ListNode prev = sorted;
        ListNode curr = sorted.next;
 
        while(head != null){
            prev = sorted;
            curr = sorted.next;
            
            if(head.val >= x){
                ListNode tail = sorted;
                while(tail.next != null){
                    tail = tail.next;
                }
                ListNode t = head.next;
                tail.next = head;
                head.next = null;
                head = t;
                continue;
            }
            
            while(curr != null && curr.val < x){
                prev = curr;
                curr = curr.next;
            }
            
            ListNode temp  =  head.next;
            prev.next = head;
            head.next = curr;
            
            head = temp;
        }
        
        return sorted.next;
    }
}