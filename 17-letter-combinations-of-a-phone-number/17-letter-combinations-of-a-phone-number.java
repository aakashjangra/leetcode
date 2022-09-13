class Solution {
    
    private void func(int idx, String str, int n, String digits, HashMap<Character, char[]> map, List<String> ans){
        if(idx == n){
            ans.add(str);
            return;
        }
        
        char[] choices = map.get(digits.charAt(idx));
        for(int i = 0; i<choices.length; i++){
            func(idx+1, str+choices[i], n, digits, map, ans);
        } 
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        
        if(digits.length() <= 0)    return ans;
        
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        func(0, "", digits.length(), digits, map, ans);
        
        return ans;
    }
}