//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int N, int K, int[] arr) {
        int sum = 0;
        for(int a: arr) sum += a;
        
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i*i <= sum; i++){
            if(sum % i == 0){
                factors.add(i);
                if(i != sum/i){
                    factors.add(sum/i);
                }
            }
        }
        
        int maxFactor = 1;
        for(int i = factors.size() - 1; i >= 0; i--){
            int factor = factors.get(i);
            if(check(factor, K, arr)) maxFactor = Math.max(maxFactor, factor);
        }
        
        return maxFactor;
    }
    public static boolean check(int factor, int k, int[] arr){
        int n = arr.length;
        
        int preSum = 0;
        for(int val: arr){
            preSum += val;
            if(preSum % factor == 0){
                k--;
            }
        }
        
        return k <= 0;
    }
    
}
        
