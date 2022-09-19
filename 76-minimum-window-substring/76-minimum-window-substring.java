class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if(m < n)   return "";
        
        Map<Character, Integer> map = new HashMap<>();
        //filling map with the values we want
        for(int i = 0; i<n; i++){
            char toFindC = t.charAt(i);
            map.put(toFindC, map.getOrDefault(toFindC, 0) - 1);
        }
        
        //checking map 
        // for(Character key: map.keySet()){
//             System.out.println(key+" "+map.get(key)+" ");
//         }
                
        //sliding the window to find best answer
        int left = 0;
        int right = 0;
        
        int finalL = 0;
        int finalR = m;
        int toFind  = map.size();
        
        while(right < m){
            char rightC = s.charAt(right);
            //then we decrease it's freq.
            if(map.containsKey(rightC)){
                map.put(rightC, map.get(rightC) + 1);
                if(map.get(rightC) == 0)
                    toFind--;
            }
            
            char leftC = s.charAt(left);
            while(left<right && (!map.containsKey(leftC) || map.get(leftC) > 0)){
                if(map.containsKey(leftC)){
                    map.put(leftC, map.get(leftC) - 1);
                }
                left++;
                leftC = s.charAt(left);
            }
            
            // System.out.println(left+" "+right);
            
            if(toFind == 0) {
                if(finalR - finalL > right - left){
                    finalL = left;
                    finalR = right;
                }
            }
            right++;
        }
            
        return finalR == m? "": s.substring(finalL, finalR+1);
    }
}
        
//         while(l < r){
//             char charL = s.charAt(l);
//             char charR = s.charAt(r);
//             // System.out.println(l+" "+r);
//             if(map.get(charL) > 0){
//                 l++;
//                 map.put(charL, map.get(charL) - 1);
//             } else if(map.get(charR) > 0){
//                 r--;
//                 map.put(charR, map.get(charR) - 1);
//             } else {
//                 break;
//             }
//         }