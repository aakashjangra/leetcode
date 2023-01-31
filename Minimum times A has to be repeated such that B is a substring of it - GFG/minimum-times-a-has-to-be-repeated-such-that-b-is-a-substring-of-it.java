//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        int ans = -1;
        
        int n = A.length();
        int m = B.length();
        
        for(int i = 0; i<n; i++){
            int index = i;
            int b = 0;
            int repetition = 1;
            
            while(b < m){
                if(index == n) {
                    //string A is repeated
                    repetition++;
                    index = 0;
                }
                
                if(B.charAt(b) != A.charAt(index)){
                    break;
                }
                
                b++;
                index++;
            }
            
            if(b == m){
                //we have found an ans
                if(ans == -1 || repetition < ans){
                    ans = repetition;
                }
            }
        }
        
        return ans;
    }
};