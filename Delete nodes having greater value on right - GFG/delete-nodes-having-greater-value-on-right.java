//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        head = rev(head);
        int max = head.data; //last elem of original list
        Node temp = head;
        
        while(temp != null && temp.next != null){
            max = Math.max(temp.data, max);
            if(temp.next.data < max){
                temp.next = temp.next.next; //removed next node
            } else{
                temp = temp.next;
            }
        }
        
        return rev(head);
    }
    Node rev(Node head){
        if(head == null || head.next == null) return head;
        Node p = head, c = head.next, n = head.next.next;
        p.next = null; //last node after reversing
        
        while(n != null){
            c.next = p; //pointer reversed
            
            p = c;
            c = n; 
            n = n.next;
        }
        
        c.next = p;
        return c; //last node is the new head
    }
}
  