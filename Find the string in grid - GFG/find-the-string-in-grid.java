//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, 1}, {1, -1}, {-1, -1}};
        List<int[]> ansList = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == word.charAt(0)){
                    boolean valid = false;
                    for(int[] dir: dirs){
                        if(findWord(0, i, j, dir[0], dir[1], grid, word)){
                            valid = true;
                            break;
                        }
                    }
                    
                    if(valid){
                        ansList.add(new int[]{i, j});
                    }
                }
            }
        }
        
        int[][] ans = new int[ansList.size()][2];
        int index = 0;
        for(int[] arr: ansList){
            ans[index++] = arr;
        }
        
        return ans;
    }
    
    public boolean findWord(int pos, int r, int c, int incrR, int incrC, char[][] grid, String word){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return false;
        }
        if(grid[r][c] != word.charAt(pos)){
            return false;
        }
        
        //at this point, char at pos matches with that in grid cell
        if(pos == word.length()-1){
            //last word
            return true; //matched
        } else {
            //keep matching ahead, remaining word
            return findWord(pos+1, r+incrR, c+incrC, incrR, incrC, grid, word);
        }
    }
}