//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    static boolean inRange(int i, int j, int n, int m){
        if(0 <= i && i < n && 0 <= j && j < m){
            return true;
        }
        
        return false;
    }
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        int MOD = 1_000_000_007;
        long prod = (N * M) % MOD;
        long totalWays = (prod * (prod - 1)) % MOD;
        long notPossible = 0;
        
        //moves that a knight can make from a cell
        int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                for(int[] move: moves){
                    int x = i + move[0];
                    int y = j + move[1];
                    if(inRange(x, y, N, M)){
                        //can't place knights here 
                        notPossible = (notPossible % MOD) + 1;
                    }
                }
            }
        }
        
        return (totalWays - (notPossible % MOD)) % MOD;
    }
}