class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> result = new ArrayList<>();
        int greatest = candies[0];
        //finding greatest 
        for(int i = 1; i<candies.length; i++){
            if(greatest < candies[i])
                greatest = candies[i];
        }
        
        for(int i = 0; i < candies.length; i++){
            if(candies[i]+extraCandies >= greatest)
                result.add(true);
            else 
                result.add(false);
        }
        
        return result;
    }
}