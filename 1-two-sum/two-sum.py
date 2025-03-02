class Solution(object):
    def twoSum(self, nums, target):
        prevSum={}
        list1 = []

        for i in range(len(nums)):
            if (target-nums[i]) in prevSum:
                list1 = [i,prevSum[target-nums[i]]]
                return list1
            else:
                prevSum[nums[i]]=i
        