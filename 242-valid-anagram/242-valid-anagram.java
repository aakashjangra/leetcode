class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> occurrences1 = new HashMap<>();
        HashMap<Character, Integer> occurrences2 = new HashMap<>();

        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(occurrences1.containsKey(c)){
                occurrences1.put(c, occurrences1.get(c)+1);
            } else {
                occurrences1.put(c, 1);
            }
            
            char d = t.charAt(i);
            if(occurrences2.containsKey(d)){
                occurrences2.put(d, occurrences2.get(d)+1);
            } else {
                occurrences2.put(d, 1);
            }
        }
        
        
        return occurrences1.equals(occurrences2);
    }
}