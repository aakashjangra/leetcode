//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printSquare(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printSquare(int n) {
        int limit = 2*n;
        for(int r = 1; r < limit; r++){
            for(int c = 1; c < limit; c++){
                int toPrint = n - Math.min(Math.min(r,c), Math.min(limit-r, limit-c)) + 1;
                System.out.print(toPrint+" ");
            }
            System.out.println();
        }
    }
}