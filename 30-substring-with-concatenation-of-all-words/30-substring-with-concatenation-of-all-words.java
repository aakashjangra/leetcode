class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(var str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(map);
        
        int wordCount = words.length;
        int wordLen = words[0].length();
        int subsLen = wordLen * wordCount;
        
        int n = s.length();
        HashMap<String, Integer> curMap = new HashMap<>(map);
        int count = 0;
        int i = 0;
        int j = 0;
        
        while(j <= n-wordLen){
            String sub = s.substring(j, j+wordLen);
    
            if(curMap.getOrDefault(sub, 0) != 0){
                 curMap.put(sub, curMap.get(sub) - 1);
                 count++;
            } else {
                i = i + 1;
                j = i;
                curMap = new HashMap<>(map);
                count = 0;
            }
            
            if(count == wordCount){
                list.add(i);
                j = i = i + 1;
                j = i;
                curMap = new HashMap<>(map);
                count = 0;
            } else if(count != 0){
                j = j + wordLen;
            }
        }

        return list;
    }
}