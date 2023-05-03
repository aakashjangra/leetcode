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
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        HashSet<String> set = new HashSet<>();
        for(String str: arr){
            StringBuilder rev = new StringBuilder(str);
            rev.reverse();
            String revStr = rev.toString();
            if(set.contains(revStr)){
                set.remove(revStr);
            } else {
                set.add(str);
            }
        }
        
        if(set.size() > 1) return false;
        if(set.size() == 1) {
            Iterator<String> itr = set.iterator();
            while(itr.hasNext()){
                String st = itr.next();
                if(!isPalindrome(st)){
                    return false;
                }
            }
        }
        
        return true;
    }
    private static boolean isPalindrome(String str){
        int e = str.length() - 1;
        int s = 0;
        while(s < e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        
        return true;
    }
}
        
