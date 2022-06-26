class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for(int i = 0; i<nums1.length; i++){
            if(hm1.containsKey(nums1[i])){
                hm1.put(nums1[i], hm1.get(nums1[i])+1);
            }
            else {
                hm1.put(nums1[i], 1);
            }
        }
        
        for(int i = 0; i<nums2.length; i++){
            if(hm2.containsKey(nums2[i])){
                hm2.put(nums2[i], hm2.get(nums2[i])+1);
            } else {
                hm2.put(nums2[i], 1);
            }
        }
        

//         hm1.forEach(
//             (k,v) -> System.out.println(k+" "+v)
//         );
//         hm2.forEach(
//             (k,v) -> System.out.println(k+" "+v)
//         );
        
        
        int size = Math.max(nums1.length, nums2.length);
        int []ans = new int[size];
        int index = 0;
        
        // for(Map.Entry<Integer, Integer> e : hm1.entrySet()){
        //     if(hm2.containsKey(e.getKey())){
        //         ans[index++] = Math.min(e.getValue(), hm2.get(e.getKey()));
        //     }
        // }
        
        // hm1.forEach((k,v) -> 
        //            if(hm2.containsKey(k)){
        //                ans[index++] = Math.min(v, hm2.get(k));
        //            }
        //            );
        
            
        for(int k: hm1.keySet()){
            if(hm2.containsKey(k)){
                       int times = Math.min(hm1.get(k), hm2.get(k));
                        while(times > 0){
                            ans[index++] = k;
                            --times;
                        }
            }
        }
            
        // System.out.println(index);
        int []ans1 = new int[index];
        
        for(int i = 0; i<index; i++){
            ans1[i] = ans[i];
        }
        
        return ans1;
    }
}