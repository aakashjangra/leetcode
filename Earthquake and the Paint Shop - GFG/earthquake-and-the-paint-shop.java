//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s[] = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric ans[] = ob.sortedStrings(N, s);
            for (int i = 0; i < ans.length; i++)
                System.out.println(ans[i].name + " " + ans[i].count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};
class Solution {
    alphanumeric[] sortedStrings(int N, String A[]) {
        SortedMap<String, Integer> smap = new TreeMap<>();
        for(String str: A){
            smap.put(str, smap.getOrDefault(str, 0) + 1);
        }
        
        alphanumeric[] ans = new alphanumeric[smap.size()];
        int index = 0;
        for(String key: smap.keySet()){
            ans[index] = new alphanumeric(key, smap.get(key));
            index++;
        }
        
        return ans;
    }
};