class Solution {
    public boolean equationsPossible(String[] equations) {
        // a bi-directional graph
        
        int[] par = new int[26];
        
        //every alphabet is parent of itself at first
        for(int i = 0; i<26; i++){
            par[i] = i;
        }

        
        for(String eq: equations){
            char x = eq.charAt(0);
            char rel = eq.charAt(1);
            char y = eq.charAt(3);
            
            if(rel == '!') continue;
            
            int px = x - 'a';
            int py = y - 'a';
            
            int parentx = par[px];
            int parenty = par[py];
            
            while(parentx != par[parentx]){
                parentx = par[parentx];
            }
            
            while(parenty != par[parenty]){
                parenty = par[parenty];
            }
            
            // System.out.println(parentx+" "+parenty);
            
            if(rel == '='){
                par[parentx] = parenty;
            }
            
        }
        
        for(String eq: equations){
            
            char x = eq.charAt(0);
            char rel = eq.charAt(1);
            char y = eq.charAt(3);
            
            if(rel == '=') continue;
            
            int px = x - 'a';
            int py = y - 'a';
            
            int parentx = par[px];
            int parenty = par[py];
            
            while(parentx != par[parentx]){
                parentx = par[parentx];
            }
            
            while(parenty != par[parenty]){
                parenty = par[parenty];
            }
            if(parentx == parenty)
                return false;
            
        }
        
        return true;
    }
}