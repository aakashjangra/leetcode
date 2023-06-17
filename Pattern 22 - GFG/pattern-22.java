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
        int limit = (n*2 - 1)/2 + 1;
        int[][] pat = new int[limit][limit];
        int i = 0;
        int num = n;
        // upper left part
        while(i < limit){
            for(int h = i; h < limit; h++){
                pat[i][h] = num;
                pat[h][i] = num;
            }
            num--;
            i++;
        }
        
        for(i = 0; i<limit; i++){
            for(int j = 0; j<limit; j++){
                System.out.print(pat[i][j]+" ");
            }
            for(int j = limit-2; j>=0; j--){
                System.out.print(pat[i][j]+" ");
            }
            
            System.out.println();
        }
        
        for(i = limit-2; i>=0; i--){
            for(int j = 0; j<limit; j++){
                System.out.print(pat[i][j]+" ");
            }
            for(int j = limit-2; j>=0; j--){
                System.out.print(pat[i][j]+" ");
            }
            
            System.out.println();
        }

    }
}