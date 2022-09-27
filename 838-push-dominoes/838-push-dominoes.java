class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] domino = dominoes.toCharArray();
        
        int[] indexes = new int[n+2];
        char[] dirs = new char[n+2];

        //left most
        indexes[0] = -1;
        dirs[0] = 'L';
        int len = 1;
        
        //marking parts
        for(int i = 0; i<n; i++){
            
            if(domino[i] != '.'){
                indexes[len] = i;
                dirs[len] = domino[i];
                len++;
            }
            
        }
        
        //right most
        indexes[len] = n;
        dirs[len] = 'R';
      //len represents last Index of Array indexes and dirs 
        
        //making domino effect
        for(int index = 0; index<len; index++){
            int i = indexes[index]+1, j = indexes[index+1]-1;
            char x = dirs[index], y = dirs[index+1];
            
            if(x == y){
                while(i <= j){
                    domino[i] = x;
                    i++;
                }
            } else if(x == 'R' && y == 'L'){
                //half will be filled with 'R' and right half will be filled with 'L'
                while(i < j){
                    domino[i] = x;
                    domino[j] = y;
                    i++;
                    j--;
                }
            }
        }
        
        return new String(domino);
    }
}