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
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        int n = 1;
        for(long val: query){
            n = Math.max(n, (int)Math.sqrt(val));
        }
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        //marking primes in prime array
        //here n/2 might need to change to n
        for(int i = 2; i<=n/2; i++){
            if(primes[i]){
                for(int j = i+1; j<=n; j++){
                    if(j % i == 0){
                        primes[j] = false;
                    }
                }   
            }
        }
       
        ArrayList<Integer> satisfyingCounts = new ArrayList<>();
        int[] dp = new int[n+1];

        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1];
            if(primes[i]) dp[i]++;
        }
        
        //constituting answer
        for(long val: query){
            int root = (int)Math.sqrt(val);
            satisfyingCounts.add(dp[root]);
        }
        return satisfyingCounts;
    }
}