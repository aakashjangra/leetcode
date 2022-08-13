class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int[][] matrix = new int[map.size()][2];
        int index = 0;
        for(int key: map.keySet()){
            matrix[index][0] = map.get(key);
            matrix[index][1] = key;
            index++;
        }
        
        Arrays.sort(matrix, ((a,b) -> a[0] != b[0]? a[0] - b[0] : b[1] - a[1]));
        
//         for(int []arr: matrix){
            
//             System.out.println(arr[0]+" "+arr[1]);
            
//         }
        
        index = 0;
        for(int[] arr: matrix){
            int freq = arr[0];
            int num = arr[1];
            while(freq > 0){
                nums[index++] = num;
                freq--;
            }
        }
        
        return nums;
    }
}