class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length  == 0){
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        for(String str : strs){
            char []arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            
            if(!ans.containsKey(sorted)){
                ans.put(sorted, new ArrayList());
            }
            ans.get(sorted).add(str);
        }
        
        return new ArrayList(ans.values());
        
    }
}