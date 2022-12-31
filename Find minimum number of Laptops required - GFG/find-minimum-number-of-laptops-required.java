//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int n, int[] start, int[] end) {
        PriorityQueue<int[]> pairsHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> freeTime = new PriorityQueue<>();
        
        for(int i = 0; i<n; i++){
            pairsHeap.add(new int[]{start[i], end[i]});
        }
        
        //making ans up
        int laptops = 0;
        
        while(pairsHeap.size() > 0){
            int[] top = pairsHeap.poll();
            
            if(freeTime.size() > 0){
                if(freeTime.peek() <= top[0]){
                    freeTime.poll();
                } else {
                    laptops++;
                }
            } else {
                laptops++;
            }
            
            freeTime.add(top[1]);
        }
        
        return laptops;
    }
}