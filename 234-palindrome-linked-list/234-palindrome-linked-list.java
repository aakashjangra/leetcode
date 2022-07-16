/**
 * Definition for singly-linked list.
 * public class ListListNode {
 *     int val;
 *     ListListNode next;
 *     ListListNode() {}
 *     ListListNode(int val) { this.val = val; }
 *     ListListNode(int val, ListListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }
        ListNode p, c, n;
        p = head;
        c = head.next;
        n = head.next.next;

        while(n != null){
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }
        head.next = null;
        c.next = p;

        return c;

    }
    static ListNode split(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode half = slow.next;
        slow.next = null;
        
        return half;
    }

    

    public boolean isPalindrome(ListNode head) {
        
      ListNode half = split(head);
        half = reverse(half);
        
        while(half != null && head != null){
            if(head.val != half.val){
                return false;
            }
            head = head.next;
            half = half.next;
        }

        if((head == null || head.next == null) && (half == null || half.next == null) ){
            return true;
        } else {
            return false;
        }
        
    }
}