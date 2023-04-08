//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        int i = 0, j = 1;
        int n = arr.length;
        
        // while(j < n){
        //     int val1 = arr[i], val2 = arr[j];
            
        //     if((val1 >= 0 && val2 >= 0) || (val1 < 0 && val2 < 0)){
        //         ans.add(val1);
        //         i += 1;
        //         j += 1;
        //     } else {
        //         i += 2;
        //         j += 2;
        //     }
        // }
        
        // if(i < n) ans.add(arr[i]);
        
        //stack se hi hoga bhai....
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while(i < n){
            int cur = arr[i];
            if(!stack.isEmpty() && !sameSign(stack.peek(), cur)){
                stack.pop();
            } else {
                stack.push(cur);
            }
            i++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>(stack);
        Collections.reverse(ans);
        return ans;
    }
    public static boolean sameSign(int a, int b){
        if((a >= 0 && b >= 0) || (a < 0 && b < 0)) return true;
        
        return false;
    }
}
