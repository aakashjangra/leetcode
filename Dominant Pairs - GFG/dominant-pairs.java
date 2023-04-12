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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dominantPairs(int n, int[] arr) {
        //sorting half-half array (to maintain index condition) and using BS to search for valid number and adding that and valid numbers smaller than that into ans...
        int mid = n/2;
        Arrays.sort(arr, 0, mid);
        Arrays.sort(arr, mid, n);
        int ans = 0;
        
        for(int i = mid-1; i>=0; i--){
            int index = bs(i, n, arr);
            if(index == -1){
                break;
            } else {
                ans += index - mid + 1;
            }
        }
        
        return ans;
    }
    public static int bs(int index, int n, int[] arr){
        int s = n/2, e = n-1;
        int ans = -1;
        
        while(s <= e){
            int mid = s + ((e - s)/2);
            if(arr[index] >= 5*arr[mid]){
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return ans;
    }
}
        
