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
 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null || l2 == null){
            return l2;
        }
        
        
        //making both linkedlists equal
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        while(temp1 != null || temp2 != null){
            
            if(temp1 == null){
                ListNode tmp = new ListNode(0);
                tmp.next = l1;
                l1 = tmp;
            } else {
                 temp1 = temp1.next;
            }
            
            if(temp2 == null){
                ListNode tmp = new ListNode(0);
                tmp.next = l2;
                l2 = tmp;
            } else {
                temp2 = temp2.next;                
            }
        }
        
        boolean carry = true;
        
        while(carry){
            
            carry = false;
            
            ListNode s = l1;
            ListNode carr = l2;
            ListNode prev = null;
            
            while(s != null){
                prev = carr;
                
                int num = s.val;
                int c = carr.val;
                
                int k = num+c;
                
                s.val = k%10;
                carr.val = k/10;
                
                if(carr.val >= 1){
                    carry = true;
                }
                
                s = s.next;
                carr = carr.next;
            }
            
            prev.next = new ListNode(0);
            
            if(l2.val == 1){
                ListNode n = new ListNode(0);
                n.next = l1;
                l1 = n;
            } else {
                l2 = l2.next;
            }
            
        }
        
        return l1;
    }
}