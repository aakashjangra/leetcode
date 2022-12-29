//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i<N; i++){
            int cur = asteroids[i];
            if(cur > 0){
                //cur is +ve 
                st.push(cur);
            } else {
                //cur is -ve 
                boolean notUsed = true;
                
                while(!st.isEmpty() && st.peek() > 0){
                    int absCur = Math.abs(cur);
                    int other = st.pop();
                    
                    if(absCur == other){
                        notUsed = false;
                        break;
                    } else if(other > absCur){
                        notUsed = false;
                        st.push(other); 
                        break;
                    } 
                }
                
                if(notUsed){
                    st.push(cur);
                }
            }
        }
        
        int size = st.size();
        
        int[] ans = new int[size];
        for(int i = size - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}
