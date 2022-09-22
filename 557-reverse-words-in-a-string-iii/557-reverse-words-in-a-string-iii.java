class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int start = 0;
        int end = 0;
        for(int i = 0; i<=n; i++){
            if(i == n || arr[i] == ' '){
                int st = start;
                int e = end-1;  
                start = i+1;
                end++;
                
                //reversing characters from s to e
                while(st < e){
                    char temp = arr[st];
                    arr[st] = arr[e];
                    arr[e] = temp;
                    st++;
                    e--;
                }
            } 
            else 
            {
                end++;
            }
        }
        
        return new String(arr);
    }
}