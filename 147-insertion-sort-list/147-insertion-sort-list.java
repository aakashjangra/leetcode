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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode sorted = new ListNode(0);
        
        while(head != null){
            ListNode prev = sorted;
            ListNode curr = sorted.next;
            while(curr != null && curr.val < head.val){
                prev = curr;
                curr =  curr.next;
            }
            
            ListNode temp = head.next;
            prev.next = head;
            head.next = curr;

            head = temp;
        }
        
        return sorted.next;
    }
}