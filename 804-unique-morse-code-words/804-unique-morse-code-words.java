class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        int transformations = 0;
        Set<String> set = new HashSet<>();
        for(String str: words){
            int n = str.length();
            String cur_code = "";
            for(int i = 0; i<n; i++){
                cur_code += table[str.charAt(i) - 'a'];
            }
            if(set.add(cur_code))
                transformations++;
        }
        
        return transformations;
    }
}