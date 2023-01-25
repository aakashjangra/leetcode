//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        int n = s.length();
        int maxToDuplicate = 0;
        String pre = "";
        for(int i = 0; i<n/2; i++){
            int matched = 0;
            pre += s.charAt(i);
            if(pre.equals(s.substring(i+1, (i+1)*2))){
                maxToDuplicate = i+1;
            }
        }
        
        return maxToDuplicate > 0? n - (maxToDuplicate - 1): n;
    }
}