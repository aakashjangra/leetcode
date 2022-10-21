//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int r, int c, int[][] a)
    {
        // code here
        int size = r*c; //total elements in matrix
        int[] ans = new int[size];
        int index = 0; //will increase index as we add elements
        int level = (Math.min(r, c) + 1)/2; //total levels - 1 = one circle including LBRT (left, bottom, right, top)

        while(level > 0){
            int minc = level-1, maxc = c-level, minr = level-1, maxr = r-level;
            // System.out.printf("minc %d, maxc %d, minr %d, maxr %d\n", minc, maxc, minr, maxr);
            //don't do left when minc and maxc are same
            //left - leaving first and last elements
            if(minc != maxc){
                for(int i = minr+1; i < maxr; i++){
                    ans[index++] = a[i][minc];
                }
            }
            
            //don't do bottom when minr and maxr are same
            //bottom - includes all elements
            if(minr != maxr){
                for(int j = minc; j<=maxc; j++){
                    ans[index++] = a[maxr][j];
                }
            }
            //right - leaving first and last elements
            for(int i = maxr-1; i > minr; i--){
                ans[index++] = a[i][maxc];
            }
            //top - includes all elements
            for(int j = maxc; j >= minc; j--){
                ans[index++] = a[minr][j];
            }
            
            level--;
        }
        
        return ans;
    }
}