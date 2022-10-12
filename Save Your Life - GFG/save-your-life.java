//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //kind of like kedane's algorithm
        Map<Character, Integer> ascii = new HashMap<>();
        for(int i = 0; i<n; i++){
            ascii.put(x[i], b[i]);
        }
        int maxSum = 0;
        int sum = 0;
        int start = 0, end = 0, prev = 0;
        int len = w.length(); //len of str and n is different
        for(int i = 0; i<len; i++){
            char c = w.charAt(i);
            int val = c;
            if(ascii.get(c) != null){
                val = ascii.get(c);
            }
            sum += val;
            if(maxSum < sum){
                maxSum = sum;
                end = i;
                start = prev;
            }
            if(sum < 0){
                prev = i+1;
                sum = 0;
            }
        }
        
        return w.substring(start, end+1);
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends