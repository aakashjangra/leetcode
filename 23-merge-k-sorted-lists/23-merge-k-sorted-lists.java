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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(123);
        ListNode ptr = dummy;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists){
            if(head != null)
                minHeap.add(head);
        }
        
        while(minHeap.size() > 0){
            ListNode curr = minHeap.poll();
            
            ptr.next = curr;
            ptr = ptr.next;

            curr = curr.next;
            if(curr != null)
                minHeap.add(curr);
            
        }

        
        return dummy.next;
    }
}