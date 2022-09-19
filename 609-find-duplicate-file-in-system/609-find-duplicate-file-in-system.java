class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ansList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String wholePath: paths){
            String[] pathInChunks = wholePath.split(" ");
            
            String path = pathInChunks[0];
            int n = pathInChunks.length;
            
            for(int idx = 1; idx < n; idx++){
                String content = "";
                String specificPath = "";
                boolean foundOpenBracket = false;
                String pathAndFiles = pathInChunks[idx];
                int len = pathAndFiles.length();
    //debugging
                // System.out.println(pathAndFiles);
                
                //looping from first char to last-1 as we are not interested in brackets
                for(int i = 0; i<len; i++){
                    if(pathAndFiles.charAt(i) == '('){
                        content = pathAndFiles.substring(i+1, len-1);
                        break;
                    }
                    specificPath += pathAndFiles.charAt(i);
                }       
                if(map.containsKey(content)){
                    map.get(content).add(path+"/"+specificPath);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(path+"/"+specificPath);
                    
                    map.put(content, temp);
                }
             
            }
            
        }
        
        for(String key: map.keySet()){
            if(map.get(key).size() > 1)
                ansList.add(map.get(key));
        }
        
        
        return ansList;
    }
}