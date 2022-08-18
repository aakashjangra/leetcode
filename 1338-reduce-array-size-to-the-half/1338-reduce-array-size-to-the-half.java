class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int values[] = new int[map.size()];
        int idx = 0;
        for(int a: map.values()){
            values[idx] = a;
            idx++;
        }
        Arrays.sort(values);
        int count = 0;
        for(int i = values.length-1; i>=0; i--){
            count += values[i];
            if(count >= n/2)
                return values.length-i;
        }
        
        return -1;
    }
}