import sys
class Solution(object):
    def maxSubArray(self, nums):
        Max = -99999
        Sum = 0

        for i in range (len(nums)) :
            Sum += nums[i]
            Max = max(Max,Sum)
            if Sum < 0 : Sum = 0

        return Max
        
        