//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        int n = heights.length, m = heights[0].length;
        int[] source = {0, 0};
        int[] destination = {n-1, m-1};
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        // [] -> {effort, row, col}
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[][] effort = new int[n][m]; //this will store, effort from source to a particular cell
        for(int[] row: effort) Arrays.fill(row, Integer.MAX_VALUE); //initializing with max. value

        q.add(new int[]{0, source[0], source[1]});
        effort[source[0]][source[1]] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int eff = cur[0], x = cur[1], y = cur[2];
                
                //in 4 directions
                for(int i = 0; i<4; i++){
                    int r = x+dr[i], c = y+dc[i];
                    if(r < 0 || c < 0 || r >= n || c >= m) {
                        //invalid indices, continue to next one
                        continue;
                    }
                    int maxEffort = Math.max(eff, Math.abs(heights[x][y] - heights[r][c]));
                    if(effort[r][c] > maxEffort){
                        q.add(new int[]{maxEffort, r, c});
                        effort[r][c] = maxEffort;
                    }
                }
            }
        }
        
        return effort[destination[0]][destination[1]];
    }
}