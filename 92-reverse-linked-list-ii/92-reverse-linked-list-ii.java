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
    static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode p = null, c = head, n = head.next;
        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        
        return p;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode pstart = null, start = null, end = null;
        
        ListNode temp = head;
        int count = 1;
        while(temp != null){
            if(count == left-1){
                pstart = temp;
            } else if(count == left){
                start = temp;
            }
            
            if(count == right){
                end = temp.next;
                temp.next = null;
            }
            count++;
            temp = temp.next;
        }
        
        ListNode rev = reverse(start);
        start.next = end;
        
        if(pstart == null){
            head = rev;
        } else {
            pstart.next = rev;
        }
        
        
        
        return head;
    }
}