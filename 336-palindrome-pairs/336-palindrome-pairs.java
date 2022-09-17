public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>(); 
        if (words == null || words.length < 2) return ans;
		
		// Build a map of all the current words. Will be used to find pairs in constant time.
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        
        for (int i=0; i<words.length; i++) {
			
			// Creating a reverse string to use for checking
            String reverse = new StringBuilder(words[i]).reverse().toString();
            
			// Start of Manacher's Algorithm
            char[] extended = new char[words[i].length()*2+1];
            for(int j = 0; j < words[i].length(); ++j)
                extended[j*2+1]=words[i].charAt(j);
            
            int center = 0, radius = 0;
            int oldCenter = 0, oldRadius = 0;
            int mirroredCenter = 0, maxMirroredRadius = 0;
            int[] radii = new int[extended.length];
            
            while(center<extended.length){
                while(center-radius-1>=0 && 
                      center+radius+1<extended.length && 
                      extended[center-radius-1]==extended[center+radius+1])
                    radius++;
                
                radii[center] = radius;
                oldCenter = center;
                oldRadius = radius;
                
                // Check for any pair from the detected palidrome
                checkPair(radius,center,radii.length-1,i,reverse,map,ans);
                center++;
                radius = 0;

                while(center<=oldCenter+oldRadius){
                    mirroredCenter = oldCenter - (center - oldCenter);
                    maxMirroredRadius = oldCenter + oldRadius - center;

                    if(radii[mirroredCenter]<maxMirroredRadius){
                        radii[center]=radii[mirroredCenter];
						// Check for any pair from the detected palidrome
                        checkPair(radii[center],center,radii.length-1,i,reverse,map,ans);
                        center++;
                    } else if (radii[mirroredCenter]>maxMirroredRadius){
                        radii[center]=maxMirroredRadius;
						// Check for any pair from the detected palidrome
                        checkPair(radii[center],center,radii.length-1,i,reverse,map,ans);
                        center++;
                    } else {
                        radius = maxMirroredRadius;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
    
    private void checkPair(int radius, int center, int end, int i, String reverse, Map<String,Integer> map, List<List<Integer>> ans){
		// If the palidrome reaches to the start of the word
        if(center-radius==0){
            String check = reverse.substring(0,reverse.length()-radius);
            if(map.containsKey(check))
                addPair(map.get(check),i,ans);
        }
         // If the palidrome reaches to the end of the word. Also takes care of possible duplicate case.
        if(center+radius==end && center!=end){
            String check = reverse.substring(radius);
            if(map.containsKey(check))
                addPair(i,map.get(check),ans);
        }
    }
    
    private void addPair(int i, int j, List<List<Integer>> ans){
		// Do not add if the words are the same
        if(i==j) return;
        
        List<Integer> pair = new ArrayList<>(2);
        pair.add(i);
        pair.add(j);
        ans.add(pair);
    }
}