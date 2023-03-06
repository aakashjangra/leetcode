//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        String bin = Integer.toBinaryString(n);
        int consec = 0;
        int ans = 0;
        
        for(int i = 0; i<bin.length(); i++){
            int bit = Integer.parseInt(bin.charAt(i)+"");
            
            if(bit == 1){
                //set bit
                consec++;
            } else {
                consec = 0;
            }
            
            if(consec == 3){
                bit = 0;
                consec = 0;
            }
            
            ans = (ans << 1);
            ans = (ans | bit);
        }
        
        return ans;
    }
}
        
