//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.removeStudents(H,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        int[] table = new int[N];
        int len = 0;
        table[len] = H[0];
        len++;
        
        for(int i = 1; i<N; i++){
            if(table[0] > H[i]){
                table[0] = H[i];
            } else if(table[len-1] < H[i]){
                table[len] = H[i];
                len++;
            } else {
                //ceil value
                table[ceilIndex(0, len-1, table, H[i])] = H[i];
            }
        }
        
        return N - len;
    }
    
    private int ceilIndex(int l, int r, int[] table, int key){
        int index = -1;
        
        while(l <= r){
            int mid = r + ((l - r)/2);
            
            if(table[mid] < key){
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return index + 1;
    }
};