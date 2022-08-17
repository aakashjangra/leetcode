class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> morse_code = new HashMap<>();
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char alphabet = 'a';
        for(int i = 0; i<26; i++){
            morse_code.put(alphabet, table[i]);
            alphabet += 1;
        }
        
        int transformations = 0;
        Set<String> set = new HashSet<>();
        for(String str: words){
            int n = str.length();
            String cur_code = "";
            for(int i = 0; i<n; i++){
                cur_code += morse_code.get(str.charAt(i));
            }
            if(set.add(cur_code))
                transformations++;
        }
        
        return transformations;
    }
}