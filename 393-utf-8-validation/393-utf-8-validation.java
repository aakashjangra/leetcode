class Solution {

    private int calcMSBs(int num){
        int mask = 1<<7; // 1st bit is set only
            // 1 0 0 0 0 0 0 0 
        int count = 0; //no. of most significant bits which are set
      
        while((num&mask) > 0){
            count++;
            num = num<<1;
        }
        
        return count;
    }
    
    public boolean validUtf8(int[] data) {
        int n = data.length;
        
        int count = 0;
        for(int a: data){
            int setBits = calcMSBs(a);
            if(setBits > 4) return false;
            // System.out.print(setBits+" ");
            
            if(count > 0){
                if(setBits == 1){
                    count--;
                } else {
                    return false;
                }
            }
            else if(setBits > 0){
               if(setBits == 1)
                   return false;
               count = setBits-1;
            }
        }        
        
        return count>0? false: true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}