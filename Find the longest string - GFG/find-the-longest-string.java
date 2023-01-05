//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        Arrays.sort(arr); // lexicographically sorted
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        String ans = "";
        
        for(String str: arr){
            int len = str.length();
            boolean add = false;
            if(len > 1){
                String prevSubstring = str.substring(0, len-1);
                if(set.contains(prevSubstring)){
                    add = true;
                }
            } else {
                add = true;
            }
            
            if(add){
                set.add(str);
                if(len > maxLen){
                    maxLen = len;
                    ans = str;
                }
            }
        }
        
        return ans;
    }
}
        
