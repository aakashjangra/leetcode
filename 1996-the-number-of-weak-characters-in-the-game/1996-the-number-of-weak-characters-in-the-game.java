class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int weakChars = 0;
        int n = properties.length;
        
        Arrays.sort(properties, (a,b)-> a[0] == b[0]? b[1] - a[1]: a[0] - b[0]); 
        
        int max = properties[n-1][1];
        
        //starting from the second last pair
        for(int i = n-2; i>=0; i--){
            
            if(properties[i][1] < max){
                weakChars++;
            } else {
                max = properties[i][1];
            }
        }
        
        return weakChars;
    }
}