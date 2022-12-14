//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        Vector<Integer> ans = new Vector<>();
        ans.add(-1);
        int s = 0;
        int e = 0;
        int count = 0;
        int max = 0;
        
        for(int i = 0; i<n; i++){
            int val = str.charAt(i) - '0';
            if(val == 0){
                count++;
            } else {
                count--;
            }
            
            if(count > max){
                //update answer
                e = i;
                ans.set(0, s+1);
                if(ans.size() == 2){
                    ans.set(1, e+1);
                } else {
                    ans.add(e+1);
                }
                max = count;
            }
            
            if(count < 0){
                s = i+1;
                e = i+1;
                count = 0;
            }
        }
        
        return ans;
    }
}