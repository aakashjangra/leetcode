//{ Driver Code Starts
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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int oldColor = image[sr][sc];
        int m = image.length, n = image[0].length;
        int[][] vis = new int[m][n];
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{sr, sc});
        vis[sr][sc] = 1;
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0){
                int[] cur = bfs.poll();
                int r = cur[0], c = cur[1];
                image[r][c] = newColor; 
                
                for(int[] dir: dirs){
                    int newR = r + dir[0], newC = c + dir[1];
                    if(newR < m && newC < n && newR >= 0 && newC >= 0 && vis[newR][newC] == 0 && image[newR][newC] == oldColor){
                        bfs.add(new int[]{newR, newC});
                        vis[newR][newC] = 1;
                    }
                }
            }
        }
        
        return image;
    }
}