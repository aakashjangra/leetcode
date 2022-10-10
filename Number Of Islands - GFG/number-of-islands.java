//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    private int countNoOfIslands(int m, int n, int[][] mat){
        int count = 0;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1) {
                    count++;
                    dfs(i, j, m, n, mat);
                }
            }
        }
        
        return count;
    }
    private void dfs(int i, int j, int m, int n, int[][] mat){
        if(i < 0 || j < 0 || i >= m || j >= n || mat[i][j] == 0){
            return;
        }
        
        mat[i][j] = 0;
        
        dfs(i-1, j, m, n, mat);
        dfs(i+1, j, m, n, mat);
        dfs(i, j-1, m, n, mat);
        dfs(i, j+1, m, n, mat);
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int k = operators.length;

        int[][] mat = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();

        for(int[] cell: operators){
            mat[cell[0]][cell[1]] = 1;
            int[][] temp = new int[rows][cols];
            for(int i = 0; i<rows; i++){
                for(int j = 0; j<cols; j++){
                    temp[i][j] = mat[i][j];
                }
            }
            int nOfIslands = countNoOfIslands(rows, cols, temp);
            ans.add(nOfIslands);
        }
        
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends