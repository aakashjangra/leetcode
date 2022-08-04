class Solution {
    private boolean ifeven(int a){
        if(a % 2 == 0) return true;
        return false;
    }
    public int mirrorReflection(int p, int q) {
        while(ifeven(p) && ifeven(q)){
            p /= 2;
            q /= 2;
        }
        
        if(ifeven(p)) return 2;
        if(ifeven(q)) return 0;
        
        return 1;
    }
}