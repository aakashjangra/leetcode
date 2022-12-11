//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: nums){
            int val = a%k;
            //now val < k
            //zero ko bhi to add krna hai
            if(val == 0){
                if(map.containsKey(0)){
                    map.remove(0);    
                } else {
                    map.put(0, 1);
                }
                
            } else if(map.containsKey(k-val)){
                if(map.get(k-val) == 1){
                    map.remove(k-val);
                } else {
                    map.put(k-val, map.get(k-val) - 1);    
                }
            } else {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        
        return map.isEmpty();
    }
}