//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        // index -> number. for answer
        Map<Integer, Integer> map = new HashMap<>();
        char fs1 = s1.charAt(0), fs2 = s2.charAt(0); //first char of s1 & s2
        
        boolean neg = fs1 == '-' || fs2 == '-'? 
                        (fs1 == '-' && fs2 == '-'?
                            false
                            : true)
                            : false;
        
        s1 = truncate(s1);
        s2 = truncate(s2);
        int n = s1.length(), m = s2.length();
        
        
        for(int i = n-1; i>=0; i--){
            int carry = 0;
            int place = (n-i)-1;
            for(int j = m-1; j>=0; j--){
                int cur = ('0'-s1.charAt(i)) * ('0'-s2.charAt(j));
                
                int prevValue = map.getOrDefault(place, 0);
                cur += prevValue + carry;
                carry = cur/10;
                cur %= 10; //less than 10
                
                map.put(place, cur); 
                place++;
                // System.out.println(cur+" and "+carry);
            }
            
            if(carry != 0) map.put(place, map.getOrDefault(place, 0) + carry); 
            
            // System.out.println(carry);
        }
        
        int len = map.size();
        int index = len;
        int incr = 0;
        if(neg) incr = 1;
        char[] ans = new char[len+incr];
        while(index > 0){
            ans[len - index + incr] = (char)((int)('0')+map.get(index-1));  
            // System.out.println(index-1+" "+map.get(index-1));
            index--;
        }
        
        if(neg) ans[0] = '-';  
        
        return new String(ans);
    }
    public String truncate(String temp){
        int n = temp.length();
        int start = 0;
        while(start < n){
            if((temp.charAt(start) == '-' || temp.charAt(start) == '0') == false) break;
            start++;
        }
        
        return start==n? "0": temp.substring(start, n);
    }
}