//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int mat[][])
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int n = mat.length; // n*n matrix
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int index = i+j;
                List<Integer> arrList = new ArrayList<>();
                if(map.containsKey(index)){
                    arrList = map.get(index);
                }else {
                    map.put(index, arrList);
                }
                
                arrList.add(mat[i][j]);
            }
        }
        
        
        int i = 0;
        while(map.containsKey(i)){
            for(int val: map.get(i)){
                ans.add(val);
            }
            i++;
        }
        
        return ans;
    }
}
