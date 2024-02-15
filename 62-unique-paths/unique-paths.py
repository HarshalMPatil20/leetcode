class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if n>m:
            temp=n
            n=m
            m=temp
        
        return int(math.factorial(m+n-2)/(math.factorial(m-1)*math.factorial(n-1)))