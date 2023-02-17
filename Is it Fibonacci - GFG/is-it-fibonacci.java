//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main
{
    static FastIO f;
    
    public static void main(String args[]) throws IOException
    {
        f = new FastIO();
        
        int t = f.nextInt();
        
        while(t-->0)
        {
            int N = f.nextInt(), K = f.nextInt();
            ArrayList<Long> GeekNum = new ArrayList<>();
            
            for(int i = 0; i < K; i++)
                GeekNum.add(f.nextLong());
            
            f.out(Solution.solve(N, K, GeekNum) + "\n");
        }
        
        f.flush();
    }
}

class FastIO
{
	BufferedReader br;
	PrintWriter bw, be;
	StringTokenizer st;

	public FastIO()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		be = new PrintWriter(System.err);
		st = new StringTokenizer("");
	}

	private void read() throws IOException
	{
		st = new StringTokenizer(br.readLine());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public String next() throws IOException
	{
		while(!st.hasMoreTokens())
			read();
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public float nextFloat() throws IOException
	{
		return Float.parseFloat(next());
	}

	public double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	public char nextChar() throws IOException
	{
		return next().charAt(0);
	}

	public void out(String s) throws IOException
	{
		bw.print(s);
	}

	public void flush() throws IOException
	{
		bw.flush();
		be.flush();
	}

	public void err(String s) throws IOException
	{
		be.print(s);
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long solve(int N, int K, ArrayList<Long> GeekNum) {
        if(K == 1) return GeekNum.get(0);
        
        long[] dp = new long[N+1];
        
        dp[0] = 0;
        dp[1] = GeekNum.get(0);
        
        int i = 2;
        for(i = 2; i<=K; i++){
            dp[i] = GeekNum.get(i-1) + dp[i-1];
        }
        
        while(i <= N){
            dp[i] = (dp[i-1] - dp[i - K - 1]) + dp[i-1];
            i++;
        }
        
        // for(long val: dp){
        //     System.out.print(val+" ");
        // }
        // System.out.println();
        
        return dp[N] - dp[N-1];
    }
}