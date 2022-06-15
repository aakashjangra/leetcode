class Solution {
    public boolean checkIfPangram(String sentence) {
       char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        if(sentence.length() < 26)
            return false;
        
        for(int i = 0; i<alphabet.length; i++){
            int count = 0;
            for(int j = 0; j<sentence.length(); j++){
                if(alphabet[i] == sentence.charAt(j))
                    ++count;
                if(count > 0)
                    break;
            }
            
            if(count == 0)
                return false;
        }
        
        return true;
    }
}