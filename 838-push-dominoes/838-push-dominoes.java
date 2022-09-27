class Solution {
    public String pushDominoes(String dominoes) {
        // will calculate the force on every domino in this 
        //+ve force means domino would fall right and -ve force means domino would fall left
        
        int n = dominoes.length(); //length of dominoes array and max. force that can be applied on any domino
        //calculate right force | +Ve force
        int force = 0;
        int[] posForce = new int[n];
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                force = n;
            } else if(dominoes.charAt(i) == 'L'){
                force = 0;
            }
            posForce[i] = force;
            if(force == 0) continue;
            force--;
        }
        
        //calculate left force | -Ve force
        force = 0;  // starting force would be zero
        int[] negForce = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(dominoes.charAt(i) == 'L'){
                force = n;
            } else if(dominoes.charAt(i) == 'R'){
                force = 0;
            }
            negForce[i] = force; 
            if(force == 0) continue;
            force--; //less neg force overtime
        }
        
        //calculating total force and making answer acc. to that
        //if total force is +ve then domino will fall right => 'R'
        //if total force is -ve then domino will fall left => 'L'
        //else it will stand still => '.'
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<n; i++){
            int totalForce = posForce[i] - negForce[i]; 
            char current = '.';
            if(totalForce > 0){
                current = 'R';
            } else if(totalForce < 0){
                current = 'L';
            }
            
            ans.append(current);
        }
        
        
        return ans.toString();
    }
}