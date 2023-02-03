//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        String dir = "right";
        int x = 0, y = 0; //co-ordinates
        int px = 0, py = 0; //stores last indices
        
        while(inRange(x, y, m, n)){
            if(arr[x][y] == 1){
                //change to 0 and change dir
                arr[x][y] = 0;
                dir = changeDir(dir);
            }
            
            px = x;
            py = y;
            //move one step in dir - direction
            switch(dir){
                case "up":
                    x = x-1;
                    break;
                case "right":
                    y = y+1;
                    break;
                case "down":
                    x = x+1;
                    break;
                default:
                    y = y-1;
            }
        }
        
        return new int[]{px, py};
    }
    static boolean inRange(int x, int y, int m, int n){
        return (0 <= x && x < m && 0 <= y && y < n); //if valid coordinates or not
    }
    static String changeDir(String dir){
        switch(dir){
            case "up":
                return "right";
            case "right":
                return "down";
            case "down":
                return "left";
            default:
                return "up";
        }
    }
}