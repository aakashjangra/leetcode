//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int[] prime;
    int[] vis;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is one means i is not a prime
        // If prime[i] is zero means i is a prime
        int size = 10_000;
        prime = new int[size];
        for(int i = 2; i<size; i++){
            if(prime[i] == 0){
                //if prime
                for(int j = 2; j*i < size; j++){
                    prime[j*i] = 1;
                }
            }
        }
    }
    
    public int shortestPath(int Num1,int Num2){
        // Complete this function using prime array
        ArrayDeque<String> bfs = new ArrayDeque<>();
        vis = new int[10000];
        //vis[i] == 0 means i is not visited yet
        
        bfs.add(Integer.toString(Num1));
        vis[Num1] = 1; //mark not prime
        
        String num2 = Integer.toString(Num2);
        
        int count = 0;
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i = 0; i<size; i++){
                String cur = bfs.poll();
                //answer found
                if(cur.equals(num2)) return count;
                //store after changing one digit that is prime
                for(int place = 0; place<4; place++){
                    List<String> nextNums = nextPrime(cur, place);
                    for(int idx = 0; idx<nextNums.size(); idx++){
                        String next = nextNums.get(idx);
                        bfs.add(next);
                    };
                        // System.out.println(nextNums);
                }
            }
            
            count++;
        }
        
        return -1;
    }
    
    private List<String> nextPrime(String num, int place){
        List<String> answers = new ArrayList<>();
        // System.out.println(num+" :- ");
        for(char i = '0'; i <= '9'; i++){
            String next = num.substring(0, place) + i + num.substring(place+1, 4);
            int nextInt = Integer.parseInt(next);
            
            //nextInt >= 1000, so that no leading zeroes are there i.e. 0988, 0045, etc.
            if(nextInt >= 1000 && prime[nextInt] == 0 && vis[nextInt] == 0){
                //if prime and not visited
                answers.add(next);
                vis[nextInt] = 1; //mark not prime, so that next time this won't be picked
                // System.out.println(next);
            }
        }
        // System.out.println("------------------------");
        
        return answers;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends