class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
       
        n=len(nums)
        ans=set()
        for i in range(n-1):
            s=nums[i]+nums[i+1]
            if s in ans:
                return True
            ans.add(s)
        return False