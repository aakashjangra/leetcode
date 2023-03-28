//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        

        while(t-->0){
            Shop shop = new Shop();

            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);

            s = br.readLine().trim().split(" ");

            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }
            
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }

    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    static int index;
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        long chocolates = 0;
        index = n;
        
        while(k > 0){
            long priceOfNextChocolate = findNextChocolate(shop, index, k);
            // System.out.println("---> " + priceOfNextChocolate+" k: "+k);
            
            if(priceOfNextChocolate == -1) return chocolates;
            
            chocolates += k/priceOfNextChocolate;
            k %= priceOfNextChocolate;
        }
        
        // System.out.println("..--->..  " + chocolates);
        
        return chocolates;
    }
    static long findNextChocolate(Shop shop, int n, long k){
        int s = 0, e = n-1;
        long ans = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            long price = shop.get(mid);
            if(price <= k){
                ans = price;
                index = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return ans;
    }

}