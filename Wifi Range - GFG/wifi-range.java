//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        int[] left = new int[N];
        int[] right = new int[N];
        
        int range = -1;
        //right
        for(int i = 0; i<N; i++){
            if(S.charAt(i) == '1'){
                //wifi refresh
                range = X;
            }
            
            if(range > -1){
                //wifi accessible
                right[i] = 1;
                range--;
            }
            // System.out.println(right[i]);
        }
        
        //left
        range = -1;
        for(int i = N-1; i >= 0; i--){
            if(S.charAt(i) == '1'){
                //wifi refresh
                range = X;
            }
            
            if(range > -1){
                //wifi accessible
                left[i] = 1;
                range--;
            }
        }
        
        for(int i = 0; i<N; i++){
            // System.out.println(left[i]+" "+right[i]);
            if(left[i] != 1 && right[i] != 1) return false;
        }
        return true;
    }
} 