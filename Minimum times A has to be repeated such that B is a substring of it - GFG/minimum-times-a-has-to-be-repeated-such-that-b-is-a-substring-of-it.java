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
        
        String rep = A;
        int n = A.length();
        int m = B.length();
        int cnt = 1;
        
        while(rep.length() < B.length()){
            rep += A;
            cnt++;
        }
        
        if(rep.indexOf(B) != -1) return cnt;
        //to be sure adding 1 more repetition
        rep += A;
        cnt++;
        if(rep.indexOf(B) != -1) return cnt;
        
        return -1;
    }
};