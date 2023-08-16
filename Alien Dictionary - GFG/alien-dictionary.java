//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adjList = new ArrayList<>(); //for graph
        for(int i = 0; i<K; i++) adjList.add(new ArrayList<>());
        int[] vis = new int[K]; //K alphabets & K nodes in graph
        int[] indegree = new int[K]; 
        
        for(int i = 0; i<N-1; i++){
            //pick pairs and compare
            String word1 = dict[i], word2 = dict[i+1];
            int index = 0;
            int minLen = Math.min(word1.length(), word2.length());
            
            while(index < minLen && word1.charAt(index) == word2.charAt(index)){
                index++;
            }
            
            if(index >= minLen){
                continue; //words are same, skip
            }
            
            char c1 = word1.charAt(index), c2 = word2.charAt(index);
            if(c1 != c2){
                // c1 < c2, we'll store charaters as integers, A being 0, B being 1 and so on...
                // c1 -> c2, so that indegree of greator one increases
                adjList.get(c1 - 'a').add(c2 - 'a'); //assuming that it has only Lowercase letters
                indegree[c2 - 'a']++;
            }
        }
        
        String topoSort = ""; //our ans
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<K; i++){
            if(indegree[i] == 0){
                q.add(i);
                vis[i] = 1;
                topoSort += (char)('a' + i);
            }
        }
        
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                for(int adj: adjList.get(cur)){
                    if(vis[adj] == 0 && --indegree[adj] == 0){
                        q.add(adj);
                        vis[adj] = 1;
                        topoSort += (char)('a' + adj);
                    }
                }
            }
        }
        
        return topoSort;
    }
}