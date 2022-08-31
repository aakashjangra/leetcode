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
        ListNode ans = new ListNode(-123);   //dummy node, as we may need to delete first node i.e. head
        ans.next = head;
        
        head = ans;
        while(head != null && head.next != null){
            while(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        
        return ans.next;
    }
}