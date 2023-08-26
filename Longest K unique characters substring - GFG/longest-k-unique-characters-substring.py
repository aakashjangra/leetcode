class Solution:
    def longestKSubstr(self, s, k):
        #To track the no of keys in dict
        count =0
        # It will store the longest substring.
        res = -1
        # To keep track of no of characters
        ds = {}
        #start of window
        i =0
        # length of string
        n = len(s)
        # if no of unique characters are greater than the lenght of string
        if k>n:
            return -1
            
        for j in range(n):
            if s[j] not in ds:
                while (count==k):
                    ds[s[i]] -=1
                        # if the count of any element becomes 0. decrement the key count
                    if (ds[s[i]] == 0):
                        del ds[s[i]]
                        count-=1
                    
                    i+=1
                # add the new element in dic with freq 1
                ds[s[j]] = 1
                # increment the key count
                count+=1
            else:
                ds[s[j]]+=1
            #calculate the longest substring.
            if count == k:
                res= max(res, j - i + 1)    
            
        #return -1 if no of unique characters are less than k
        return res 





#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        s = input()
        k = int(input())

        solObj = Solution()

        ans = solObj.longestKSubstr(s, k)

        print(ans)

# } Driver Code Ends