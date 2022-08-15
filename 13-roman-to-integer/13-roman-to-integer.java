class Solution {
    public int romanToInt(String s) {
        int num = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        for(int i = 0; i<n-1; i++){
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            if(map.get(curr) < map.get(next))
                num -= map.get(curr);
            else 
                num += map.get(curr);
        }
        num += map.get(s.charAt(n-1));
        
        return num;
    }
}