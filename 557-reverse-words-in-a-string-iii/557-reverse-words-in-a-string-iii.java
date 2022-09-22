class Solution {
    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        int n = s.length();
        
        StringBuilder aWord = new StringBuilder();
        //traversing string for every alphabet in string
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == ' '){
                answer.append(aWord.reverse()+" ");
                aWord = new StringBuilder();
            } else {
                aWord.append(c);
            }
        }
        //for the last word
        answer.append(aWord.reverse());
        
        return answer.toString();
    }
}