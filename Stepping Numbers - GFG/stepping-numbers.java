//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean inRange(int num, int n, int m){
        if(n <= num && num <= m) 
            return true;
        return false;
    }
    int steppingNumbers(int n, int m){
        // code here
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //handling 0 isolately. as 01 will be covered with 1 itself
        if(n <= 0) count++;
        for(int i = 1; i<=9; i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(inRange(cur, n, m)) count++;
            
            //for 1, low = 10
            //ld == last digit
            int ld = cur%10;
            
            int low = ld-1;
            int high = ld+1;
            int low_no = (cur*10)+low;
            
            int high_no = (cur*10)+high;
            if(low >= 0 && low_no <= m){
                q.offer(low_no);
            }
            if(high <= 9 && high_no <= m){
                q.offer(high_no);
            }
        }
        
        return count;
    }
}
