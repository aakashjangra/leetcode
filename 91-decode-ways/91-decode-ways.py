class Solution:
    def __init__(self):
        self.count = 0
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [-1]*(n+2)
        
        dp[n+1] = 0
        dp[n] = 1
        if s[n-1] == '0':
            dp[n-1] = 0
        else :
            dp[n-1] = 1
            
#         for i in range(n):
#             if s[i] == '0':
#                 dp[i] = 0

# 1 1 1 0 6
# od = 1
# td = 0
# 2 1 1 0 1 1
                
        for pos in range(n-2, -1, -1):
            # print(pos)
            # print(dp)
            
            if s[pos] == '0':
                dp[pos] = 0
                continue;
                
            oneDigit = twoDigit = 0
            
            oneDigit = dp[pos+1] if dp[pos+1] > -1 else 0;
            
            if s[pos] =='1' or (s[pos]=='2' and s[pos+1] in {'0','1','2','3','4','5','6'}):           
                twoDigit = dp[pos+2] if dp[pos+2] > -1 else 0;
            
            dp[pos] = oneDigit + twoDigit
        
        
        return dp[0]
        
#         def decode(pos):
            
#             if (pos==len(s)):
#                 return 1
        
#             if s[pos] == '0':
#                 return 0
            
#             onedigit = twodigit = 0
            
#             if dp[pos+1] == -1:
#                  dp[pos+1] = decode(pos+1)
                    
#             onedigit = dp[pos+1]
            
#             if(pos+2 <= len(s)):
#                 if s[pos] =='1' or (s[pos]=='2' and s[pos+1] in {'0','1','2','3','4','5','6'}):
#                     if dp[pos+2] == -1:
#                         dp[pos+2] = decode(pos+2)
                    
#                     twodigit = dp[pos+2]

#             dp[pos] = onedigit + twodigit
#             return dp[pos]
        
        