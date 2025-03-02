class Solution(object):
    def twoSum(self, nums, target):
        prevSum={}

        for i in range(len(nums)):
            if (target-nums[i]) in prevSum:
                return [i,prevSum[target-nums[i]]]       
            prevSum[nums[i]]=i
        