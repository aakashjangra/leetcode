class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
    
        if len(nums)<=2:
            return False
        
        arr=[]
        arr1=[]
        for i in range(len(nums)-1):
            arr.append([nums[i],nums[i+1]])
        # print(arr)
        for i in range(len(arr)):
            arr1.append(arr[i][0]+arr[i][1])
        # print(arr1)
        
        for i in range(0,len(arr1)):
            for j in range(1, len(arr1)):
                if(arr1[i] == arr1[j] and i != j):
                    return True
            
        return False