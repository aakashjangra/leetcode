class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int score = 0;
        
        if(n == 0)  return 0;   //base case
        
        Arrays.sort(tokens);
        
        if(power < tokens[0])       //base case
            return 0;
        
        int l = 0;
        int r = n-1;
        
        while(l < r){
            if(power >= tokens[l]){
                score++;
                power -= tokens[l];
                l++;
            } else {
                score--;
                power += tokens[r];
                r--;
            }
        }
        
        if(l == r && power >= tokens[l]){
            power -= tokens[l];
            l++;
            score++;
        }
        
        return score < 0? 0: score;
    }
}