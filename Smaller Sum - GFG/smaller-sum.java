//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        long[] ans = new long[n];
        for(int i = 0; i<n; i++) ans[i] = arr[i];
        Arrays.sort(ans);
        long sum = 0;
        Map<Long, Long> lessSum = new HashMap<>();
        
        long last = -1;
        for(int i = 0; i<n; i++){
            if(last != ans[i])
                lessSum.put(ans[i], sum);
            sum += ans[i];
            last = ans[i];
        }
        
        for(int i = 0; i<n; i++){
            ans[i] = lessSum.get((long)arr[i]);
        }
        
        return ans;
    }
}