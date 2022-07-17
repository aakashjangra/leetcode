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
    static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
      
        return mid;
    }
    static void printLL(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    public void reorderList(ListNode head) {
        
        Stack<ListNode> st = new Stack<ListNode>(); 
        
        ListNode mid = findMiddle(head);
      
        while(mid != null){
            st.push(mid);
            mid = mid.next;
        }
        
        ListNode c = head;
        ListNode n;
        while(st.isEmpty() == false){
            n = st.pop();
            ListNode temp = c.next;
            c.next = n;
            n.next = temp;
            c = temp;
        }

        
    }
}