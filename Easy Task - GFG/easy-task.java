//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
	public static void main (String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
                
        int t=Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            String s=in.readLine().trim();
            int q=Integer.parseInt(in.readLine().trim());
            query a[]=new query[q];
            for(int i=0;i<q;i++){
                String str=in.readLine().trim();
                String st[]=str.split(" ");
                if(st[0].trim().equals("1")){
                    a[i]=new query("1",st[1],st[2],"");
                }else{
                    a[i]=new query("2",st[1],st[2],st[3]);
                }
            }
            Solution ob=new Solution();
            ArrayList<Character> ans=ob.easyTask(n,s,q,a);
            for(char ch:ans){
                out.print(ch+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        char arr[] = s.toCharArray();
        ArrayList<Character> ans = new ArrayList<>();
        for(int i=0;i<q;i++){
            if(queries[i].type.equals("1")){
                arr[Integer.valueOf(queries[i].a)] = queries[i].b.charAt(0);
            }
            else if (queries[i].type.equals("2")){
                int freq[] = new int[26];
                int a = Integer.valueOf(queries[i].a);
                int b = Integer.valueOf(queries[i].b);
                int c = Integer.valueOf(queries[i].c);
                
                for(int j=a;j<=b;j++){
                    freq[arr[j]-97]++;
                }
                int count=0;

                for(int j=25;j>=0;j--){
                    if(freq[j]!=0){
                        
                        count = count + freq[j];
                        
                        if(count>=c){
                            ans.add((char)(j+97));
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}