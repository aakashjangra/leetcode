class Solution {
    static int findGcd(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        
        return findGcd(n2, n1%n2);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int a: deck){
            hm.put(a, hm.getOrDefault(a, 0)+1);
        }
        
        int gcd = 0;
        for(int freq: hm.values()){
            gcd = findGcd(gcd, freq);
            if(gcd <= 1){
                return false;
            }
        }
        
        return true;
    }
}