class Solution:
    def __init__(self):
        self.count = 0
    def numDecodings(self, s: str) -> int:
        dp = [-1]*(len(s)+1)
        
        def decode(pos):
            
            if (pos==len(s)):
                return 1
        
            if s[pos] == '0':
                return 0
            
            onedigit = twodigit = 0
            
            if dp[pos+1] == -1:
                 dp[pos+1] = decode(pos+1)
                    
            onedigit = dp[pos+1]
            
            if(pos+2 <= len(s)):
                if s[pos] =='1' or (s[pos]=='2' and s[pos+1] in {'0','1','2','3','4','5','6'}):
                    if dp[pos+2] == -1:
                        dp[pos+2] = decode(pos+2)
                    
                    twodigit = dp[pos+2]

            dp[pos] = onedigit + twodigit
            return dp[pos]
        
        
        return decode(0)