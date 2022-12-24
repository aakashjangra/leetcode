//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    class Node{
        int data;
        int index;
        Node(int d, int i){
            this.data = d;
            this.index = i;
        }
    }
    long wineSelling(int arr[],int n){
        ArrayDeque<Node> st = new ArrayDeque<>();
        long ans = 0;
        
        for(int i = 0; i<n; i++){
            int cur = arr[i];
            int indx = i;
            while(cur != 0 && !st.isEmpty() && isNeg(st.peek().data) != isNeg(cur)){
                Node prevNode = st.peek();
                st.pop();
                int prev = prevNode.data;
                int prevIndx = prevNode.index;
                
                int cabs = Math.abs(cur);
                int pabs = Math.abs(prev);
                int wineCount = Math.min(cabs, pabs);
                
                //calculating answer
                ans += wineCount * (indx - prevIndx);
                
                //newPair generation
                int diff = Math.abs(cabs - pabs);
                int bigger = Math.max(cabs, pabs);
                indx = (bigger == cabs? indx: prevIndx);
                
                bigger = (bigger == cabs? cur: prev);
                
                boolean neg = isNeg(bigger);
                diff = neg? -diff: diff;
                
                cur = diff;
             
                // System.out.println(i+": "+cur+" "+indx);
            }
            
            if(cur != 0){
                st.push(new Node(cur, indx));
            }
            
            // System.out.println(st);
        }
        
        return ans;
    }
    boolean isNeg(int n){
        if(n < 0) return true;
        
        return false;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends