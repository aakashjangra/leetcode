class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        m={}
        for i in arr:
            if i not in m:
                m[i]=1
            else:
                m[i]+=1

        s=[]
        for i in m:
            s.append(m[i])
        s.sort(reverse=True)
        count=0
        ans=0
        i=0
        while count<len(arr)//2:
            count+=s[i]
            i+=1
            ans+=1
        return ans