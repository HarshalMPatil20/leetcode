class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        sign = -1 if x<0 else 1 
        res=0
        x=abs(x)
        while x > 0:
            res*=10
            res+=x%10
            x/=10
        
        res*=sign

        if res>2**31-1: return 0
        if res<-2**31: return 0
        return res
        