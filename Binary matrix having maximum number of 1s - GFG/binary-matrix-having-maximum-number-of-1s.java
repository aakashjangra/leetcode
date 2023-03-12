//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class GfG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0) {
            int B = sc.nextInt();
            int arr[][] = new int[B][B];
            for(int i = 0; i < B; i++) {
                for(int j = 0; j < B; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans[] = obj.findMaxRow(arr, B);
            for(int i = 0; i < 2; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        int maxCount = 0;
        int ansRow = 0;
        for(int i = 0; i<N; i++){
            int count = N - searchFirstOne(mat, i, N);
            if(maxCount < count){
                ansRow = i;
                maxCount = count;
            }
        }
        
        return new int[]{ansRow, maxCount};
    }
    public int searchFirstOne(int mat[][], int row, int n){
        int index = n;
        int s = 0, e = n-1;
        
        while(s <= e){
            int mid = s + ((e - s)/2);
            if(mat[row][mid] == 1){
                index = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return index;
    }
};